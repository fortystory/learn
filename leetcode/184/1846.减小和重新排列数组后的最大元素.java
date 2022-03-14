/*
 * @lc app=leetcode.cn id=1846 lang=java
 *
 * [1846] 减小和重新排列数组后的最大元素
 */

// @lc code=start
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i + 1] - arr[i]) > 1) {
                arr[i + 1] = arr[i] + 1;
            }
        }
        if (arr[arr.length - 1] > arr.length) {
            return arr.length;
        } else {
            return arr[arr.length - 1];
        }
    }
}
// @lc code=end

