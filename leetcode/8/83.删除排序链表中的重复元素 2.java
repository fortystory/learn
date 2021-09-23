import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=83 lang=java
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：38 MB, 在所有 Java 提交中击败了28.15% 的用户
 * 有序 如果重复则重复元素肯定相邻
 * [83] 删除排序链表中的重复元素
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = new ListNode();
        ListNode res = new ListNode();
        cur = head;
        while(cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
}
// @lc code=end

