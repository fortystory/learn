import jdk.internal.vm.annotation.ForceInline;

/*
 * @lc app=leetcode.cn id=121 lang=java
 * 执行用时：2 ms, 在所有 Java 提交中击败了98.56% 的用户
 * 内存消耗：51.2 MB, 在所有 Java 提交中击败了80.60% 的用户
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;//数组中最小的值
        int max_diff = 0;
        for (int p : prices) {
            if(p < min_price){
                min_price = p;
            }else if(p - min_price > max_diff){
                max_diff = p - min_price;
            }
        }
        return max_diff;
    }
}
// @lc code=end