<?php

$stack = new SplStack();
$stack->push(3);
$stack->push(3);
$stack->push(2);

echo $stack->pop().PHP_EOL;
echo $stack->pop().PHP_EOL;
echo $stack->pop().PHP_EOL;
