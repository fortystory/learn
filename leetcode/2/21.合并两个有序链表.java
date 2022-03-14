/*
 * @lc app=leetcode.cn id=21 lang=java
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：37.9 MB, 在所有 Java 提交中击败了31.34% 的用户
 * 
 * 迭代
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        if(l1 == null && l2 == null){
            return node;
        }

        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        ListNode ret = node;
        while(l1 != null || l2 != null){
            if(l1 == null){
                node.next = l2;
                l2 = l2.next;
            }else if(l2 == null){
                node.next = l1;
                l1 = l1.next;
            }else if(l1.val <= l2.val){
                node.next = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        return ret.next;
    }
}
// @lc code=end

