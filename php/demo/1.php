<?php

$head = 30;
$leg = 80;

for($i = 1;$i < 26;$i++){
    $j = $head - $i;
    if($i * 2 + $j * 4 == $leg){
        echo $i," ",$j,PHP_EOL;
    }
}
