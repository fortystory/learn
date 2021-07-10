<?php
function swap($i,$j,&$str){
    $c = $str[$i];
    $str[$i] = $str[$j];
    $str[$j] = $c;
}

function su2(&$str){
    $str_len = strlen($str);
    $index = $str_len - 1;
    $count = 0;
    for ($i=$str_len - 1; $i >= 0; $i--) { 
        if($str[$i] != '*'){
            swap($i,$index,$str);
            $index --;
            $count ++;
        }
    }
    echo $str_len - $count;
}

function su1(&$str){
    $str_len = strlen($str);
    $start = '';
    $un_start = '';
    for($i = 0;$i < $str_len - 1;$i++){
        if($str[$i] == "*"){
            $start = $start.$str[$i];
        }else{
            $un_start = $un_start.$str[$i];
        }
    }
    $str = $start.$un_start;
    return strlen($start);
}

$str = "ab**cd**e*12";
echo "str:".$str;
$star_num = su1($str);
echo " | sorted:".$str." ".$star_num.PHP_EOL;




$str = "ab**cd**e*12";
echo "str:".$str;
$star_num = su1($str);
echo " | sorted:".$str." ".$star_num.PHP_EOL;