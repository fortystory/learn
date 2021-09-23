/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        TreeNode t = root;
        while(true){
            if(val > t.val){
                if(t.right == null){
                    t.right = new TreeNode(val);
                    break;
                }else{
                    t = t.right;
                }
            }else{
                if(t.left == null){
                    t.left = new TreeNode(val);
                    break;
                }else{
                    t = t.left;
                }
            }
        }
        return root;
    }
}
// @lc code=end

