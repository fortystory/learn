/*
 * @lc app=leetcode.cn id=53 lang=java
 * 执行用时：1 ms, 在所有 Java 提交中击败了95.44% 的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了18.86% 的用户
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        //动态规划
        int sum = 0;//这个和不能赋值为nums[0]
        int t = nums[0];
        for (int n : nums) {
            if(sum > 0){
                sum = sum + n;
            }else{
                sum = n;
            }
            t = Math.max(sum,t);
        }
        return t;
    }
}
// @lc code=end

