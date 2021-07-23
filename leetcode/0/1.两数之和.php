/*
 * @lc app=leetcode.cn id=1 lang=php
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $diff = 0;    
        $count = count($nums);
        $found = [];
        for($i = 0; $i < $count; $i++){
            $diff = $target - $nums[$i];
            if(array_key_exists($diff,$found) && $i != $found[$diff]){
                return [$found[$diff],$i];
            }
            $found[$nums[$i]] = $i;
        }
        return [];
    }
}
// @lc code=end

