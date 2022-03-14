/*
 * @lc app=leetcode.cn id=112 lang=java
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了71.02% 的用户
 *
 * 递归求和 最初的和是0,在子节点比较是需要先求出当前和
 * [112] 路径总和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(TreeNode node, int targetSum, int curSum) {
        curSum = node.val + curSum;
        if (node.left == null && node.right == null) {
            return targetSum == curSum;
        } else if (node.left != null && node.right == null) {
            return hasPathSum(node.left, targetSum, curSum);
        } else if (node.left == null && node.right != null) {
            return hasPathSum(node.right, targetSum, curSum);
        } else {
            return hasPathSum(node.left, targetSum, curSum) || hasPathSum(node.right, targetSum, curSum);
        }
    }
}
// @lc code=end

