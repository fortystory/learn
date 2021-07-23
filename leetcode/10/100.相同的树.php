/*
 * @lc app=leetcode.cn id=100 lang=php
 *
 * [100] 相同的树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($val = 0, $left = null, $right = null) {
 *         $this->val = $val;
 *         $this->left = $left;
 *         $this->right = $right;
 *     }
 * }
 */
class Solution {

   /**
     * @param TreeNode $p
     * @param TreeNode $q
     * @return Boolean
     */
    function isSameTree($p, $q) {
        return $this->isSame($p,$q);
    }
    
    private function isSame($p,$q){
        //如果元素是0的话 这里需要比较类型
        if(($p === null && $q != null) || ($p != null && $q === null)){ //如果一个是空节点，一个不是空节点 返回false
            return false;
        }else if($p->val === null && $q->val === null){ // 都是叶子节点,返回true 这个是结束条件
            return true;
        }else if($p->val != $q->val){ // 值不相等
            return false;
        }else{
            return $this->isSame($p->left,$q->left) && $this->isSame($p->right,$q->right); // 递归调用
        }
    }
}
// @lc code=end

