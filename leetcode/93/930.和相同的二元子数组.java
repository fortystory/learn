/*
 * @lc app=leetcode.cn id=930 lang=java
 *
 * [930] 和相同的二元子数组
 */

// @lc code=start
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int nums_len = nums.length;
        int count = 0;
        first:for (int i = 0; i < nums_len; i++) {
            int sum = 0;
            for (int j = i; j < nums_len; j++) {
                sum = sum + nums[j];
                if(sum == goal){
                    count ++;
                }
                if(sum > goal){
                    continue first;
                }
            }
        }
        return count;
    }
}
// @lc code=end

