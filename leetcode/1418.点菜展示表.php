<?php
/*
 * @lc app=leetcode.cn id=1418 lang=php
 *
 * [1418] 点菜展示表
 */

// @lc code=start
class Solution {

    /**
     * @param String[][] $orders
     * @return String[][]
     */
    function displayTable($orders) {
        //获取食物数据,即表头
        $foods = array_unique(array_column($orders,2));
        sort($foods);
        $food_count = count($foods);
        array_unshift($foods,"Table");

        //获取餐桌数据,即列头
        $table = array_unique(array_column($orders,1));
        sort($table);
        $table_count = count($table);

        //获取每个餐桌的点餐信息,可重复
        $t_f = [];
        foreach ($orders as $v) {
            $t_f[$v[1]][] = $v[2];
        }

        //这里初始化一下返回结果
        $res = [];
        $res[0] = $foods;
        for($i = 0; $i < $table_count; $i++){
            $res[$i+1][0] = $table[$i];
            for($j = 0; $j < $food_count; $j++){
                $res[$i+1][$j+1] = 0;
            }
        }

        //获取食物与结果中的键的对应关系
        $foods_index = [];
        foreach ($foods as $key => $value) {
            $foods_index[$value] = $key;
        }
        //获取餐桌与所在列的行号
        $table_index = [];
        foreach ($table as $key => $value) {
            $table_index[$value] = $key+1;
        }

        foreach ($t_f as $t => $f) {
            foreach ($f as $fo) {
                $res[$table_index[$t]][$foods_index[$fo]] ++;
            }
        }

        //这里需要转换为字符串
        for($i = 1; $i <= $table_count; $i++){
            for($j = 1; $j <= $food_count; $j++){
                $res[$i][$j] = "" . $res[$i][$j];
            }
        }

        return $res;
    }
}
// @lc code=end

