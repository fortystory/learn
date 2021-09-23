/*
 * @lc app=leetcode.cn id=226 lang=java
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：35.7 MB, 在所有 Java 提交中击败了86.50% 的用户
 * 
 * 前序遍历 
 * [226] 翻转二叉树
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        it(root);
        return root;
    }

    private void it(TreeNode node){
        if(node == null){
            return;
        }
        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;
        it(node.left);
        it(node.right);
    }
}
// @lc code=end

