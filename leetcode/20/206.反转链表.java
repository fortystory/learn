/*
 * @lc app=leetcode.cn id=206 lang=java
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：38 MB, 在所有 Java 提交中击败了83.86% 的用户
 * 
 * 迭代
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode prev = new ListNode();
        ListNode temp = new ListNode();
        prev.next = head.next;
        ListNode res = new ListNode(head.val);
        while(prev.next != null){
            temp = prev.next;
            prev.next = prev.next.next;
            temp.next = res;
            res = temp;
        }
        return res;
    }
}
// @lc code=end

