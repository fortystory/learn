/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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
    public ListNode removeElements(ListNode head, int val) {
        return dummyHeadRemoveElements(head,val);
    }

    /**
     * 通过使用虚拟头节点方法实现
     * @param head
     * @param val
     * @return
     */
    private ListNode dummyHeadRemoveElements(ListNode head, int val){
        ListNode dummyHead = new ListNode(-1, head);
        // 删除部分
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                // ListNode delNode = prev.next;
                // prev.next = delNode.next;
                // delNode.next = null;
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }
}
// @lc code=end

