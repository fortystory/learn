/*
 * @lc app=leetcode.cn id=104 lang=java
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：38.3 MB, 在所有 Java 提交中击败了63.30% 的用户
 * 递归 二叉树的深度等于左右子树深度最大值+1
 * [104] 二叉树的最大深度
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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
        }
    }
}
// @lc code=end

