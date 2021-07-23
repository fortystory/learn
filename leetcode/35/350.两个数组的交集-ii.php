<?php
/*
 * @lc app=leetcode.cn id=350 lang=php
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {

    /**
     * @param Integer[] $nums1
     * @param Integer[] $nums2
     * @return Integer[]
     */
    function intersect($nums1, $nums2) {
        $nums1_mem = [];
        foreach ($nums1 as $n) {
            if (!key_exists($n, $nums1_mem)) {
                $nums1_mem[$n] = 1;
            }else{
                $nums1_mem[$n] = $nums1_mem[$n] + 1;
            }
        }
        $res = [];
        foreach ($nums2 as $n) {
            if (key_exists($n, $nums1_mem)) {
                $res[] = $n;
                $nums1_mem[$n] = $nums1_mem[$n] - 1;//添加一次 减一
                if($nums1_mem[$n] == 0){
                    unset($nums1_mem[$n]);
                }
            }
        }

        return $res;
    }
}
// @lc code=end

