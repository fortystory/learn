<?php
namespace xingwenge\canal_php\sample;

use xingwenge\canal_php\CanalClient;
use xingwenge\canal_php\CanalConnectorFactory;
use xingwenge\canal_php\Fmt;
use Com\Alibaba\Otter\Canal\Protocol\Comn;
use Com\Alibaba\Otter\Canal\Protocol\Entry;
use Com\Alibaba\Otter\Canal\Protocol\EntryType;
use Com\Alibaba\Otter\Canal\Protocol\EventType;
use Com\Alibaba\Otter\Canal\Protocol\RowChange;
use Com\Alibaba\Otter\Canal\Protocol\RowData;

require_once __DIR__. '/../vendor/autoload.php';

ini_set('display_errors', 'On');
error_reporting(E_ALL);

class Sync{
    public static $_es_obj;

    /**
     * @param Entry $entry
     * @throws \Exception
     */
    public static function println($entry){
        switch ($entry->getEntryType()) {
            case EntryType::TRANSACTIONBEGIN:
            case EntryType::TRANSACTIONEND:
                return;
                break;
        }

        $rowChange = new RowChange();
        $rowChange->mergeFromString($entry->getStoreValue());
        $evenType = $rowChange->getEventType();
        $header = $entry->getHeader();

        echo sprintf("================> binlog[%s : %d],name[%s,%s], eventType: %s", $header->getLogfileName(), $header->getLogfileOffset(), $header->getSchemaName(), $header->getTableName(), EventType::name($header->getEventType())), PHP_EOL;
        echo $rowChange->getSql(), PHP_EOL;
        /** @var RowData $rowData */
        foreach ($rowChange->getRowDatas() as $rowData) {
            $col = self::ptColumn($rowData->getAfterColumns());
            switch ($evenType) {
                case EventType::DELETE:
                    self::ptColumn($rowData->getBeforeColumns());
                    break;
                case EventType::INSERT:
                    self::insert($header->getSchemaName(),$header->getTableName(),$col);;
                    break;
                case EventType::UPDATE:
                    self::insert($header->getSchemaName(),$header->getTableName(),$col);;
                    break;
                default:
                    echo '-------> before', PHP_EOL;
                    self::ptColumn($rowData->getBeforeColumns());
                    echo '-------> after', PHP_EOL;
                    $col;
                    break;
            }
        }
    }

    private static function ptColumn($columns){
        $arr = [];
        /** @var Column $column */
        foreach ($columns as $column) {
            $arr[$column->getName()] = $column->getValue();
            echo sprintf("%s : %s  update= %s", $column->getName(), $column->getValue(), var_export($column->getUpdated(), true)), PHP_EOL;
        }
        return $arr;
    }

    public static function insert(string $dbname,string $tablename,array $data){
        $params = [
            'index' => $dbname."_".$tablename,
            'id' => 0,
            'type' => $tablename,
            'body' => []
        ];
        $data["id"] = intval($data['id']);
        $data["age"] = intval($data['age']);
        $params['id'] = $data['id'];
        $params['body'] = $data;
        try {
            $res = self::getEs()->index($params);
        } catch (Throwable $t) {
            var_dump($t->getMessage());
            die;
        }
        var_dump($res);
    }

    public static function getEs(){
        if (!self::$_es_obj) {
            try {
                $hosts = ['10.88.21.74:9200',];
                self::$_es_obj = \Elasticsearch\ClientBuilder::create()->setHosts($hosts)->build();
            } catch (Throwable $e) {
                var_dump(__LINE__, $e->getMessage());
                die;
            }
        }
        return self::$_es_obj;
    }
}

try {
    $client = CanalConnectorFactory::createClient(CanalClient::TYPE_SOCKET_CLUE);
    # $client = CanalConnectorFactory::createClient(CanalClient::TYPE_SWOOLE);

    $client->connect("10.88.21.74", 11111);
    $client->checkValid();
    $client->subscribe("1001", "example", ".*\\..*");
    // $client->subscribe("1001", "example", "pre_rc_am.user_apply"); # 设置过滤

    while (true) {
        $message = $client->get(100);
        if ($entries = $message->getEntries()) {
            foreach ($entries as $entry) {
                // Fmt::println($entry);
                Sync::println($entry);
            }
        }
        echo date("Y-m-d H:i:s"),PHP_EOL;
        sleep(2);
    }

    $client->disConnect();
} catch (\Exception $e) {
    echo $e->getMessage(), PHP_EOL;
}
