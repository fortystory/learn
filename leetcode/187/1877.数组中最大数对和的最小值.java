/*
 * @lc app=leetcode.cn id=1877 lang=java
 * 执行用时：57 ms, 在所有 Java 提交中击败了98.92% 的用户
 * 内存消耗：53.9 MB, 在所有 Java 提交中击败了74.19% 的用户
 * 
 * 最大和最小 首位依次相加
 * 排序 双指针
 * [1877] 数组中最大数对和的最小值
 */

// @lc code=start
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int ans = 0;
        while(left < right){
            ans = Math.max(ans,nums[left] + nums[right]);
            left ++;
            right --;
        }

        return ans;
    }
}
// @lc code=end

