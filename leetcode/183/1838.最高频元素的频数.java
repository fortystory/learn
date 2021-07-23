import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1838 lang=java
 * 执行用时：31 ms, 在所有 Java 提交中击败了98.97% 的用户
 * 内存消耗：54.3 MB, 在所有 Java 提交中击败了14.32% 的用户
 * [1838] 最高频元素的频数
 */

// @lc code=start
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        long sum = 0;
        int l = 0;//左
        for (int r = 0; r < nums.length; ++r) {
           sum = sum + nums[r];
           while(l < r && sum + k < (long)nums[r] * (r - l + 1)){
               sum = sum - nums[l];
               l++;
           }
           ans = Math.max(ans,r - l + 1);
        }
        return ans;
    }
}
// @lc code=end

