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
        int[] pre_sum = new int[nums_len + 1];
        pre_sum[0] = 0;
        for (int i = 0; i < nums_len; i++) {
            //前缀和数组
            pre_sum[i + 1] = nums[i] + pre_sum[i];
        }
        for (int i = 0; i < pre_sum.length; i++) {
            if(pre_sum[i] == goal){
                count ++;
            }else{
                for (int j = 0; j < i; j++) {
                    if(pre_sum[i] - pre_sum[j] == goal){
                        count ++;
                    }
                }
            }
        }
        return count;
    }
}
// @lc code=end

