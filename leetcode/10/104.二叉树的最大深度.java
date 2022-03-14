/*
 * @lc app=leetcode.cn id=104 lang=java
 * 执行用时：1 ms, 在所有 Java 提交中击败了17.79% 的用户
 * 内存消耗：38 MB, 在所有 Java 提交中击败了91.62% 的用户
 * 
 * 深度遍历
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
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        TreeNode n = new TreeNode(-1);
        int cs = 0;
        int level_count = 0;
        while(!q.isEmpty()){
            cs = q.size();
            for (int i = 0; i < cs; i++) {
                n = q.poll();
                if(n.left != null){
                    q.offer(n.left);
                }
                if(n.right != null){
                    q.offer(n.right);
                }
            }
            level_count ++;
        }
        return level_count;
    }
}
// @lc code=end

