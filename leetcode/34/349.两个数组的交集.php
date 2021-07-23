<?php
/*
 * @lc app=leetcode.cn id=349 lang=php
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {

    /**
     * @param Integer[] $nums1
     * @param Integer[] $nums2
     * @return Integer[]
     */
    function intersection($nums1, $nums2) {
        // return array_unique(array_intersect($nums1,$nums2));
        $nums1_mem = [];
        foreach ($nums1 as $n) {
            if(!key_exists($n,$nums1_mem)){
                $nums1_mem[$n] = 1;
            }
        }
        foreach ($nums2 as $n) {
            if (key_exists($n, $nums1_mem)) {
                $nums1_mem[$n] = $nums1_mem[$n] + 1;
            }
        }
        $res = [];
        foreach ($nums1_mem as $k => $v){
            if($v > 1){ //出现超过一次的
                $res[] = $k;
            }
        }
        return $res;
    }
}
// @lc code=end