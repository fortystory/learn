/*
 * @lc app=leetcode.cn id=160 lang=java
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：41.4 MB, 在所有 Java 提交中击败了29.54% 的用户
 * 
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode A = headA;
        ListNode B = headB;
        //这里相当于两个链表各遍历一遍,交点前长度分别是a和b,公共部分长度为c
        //则AB会在交点相遇,各自所走的长度为a+c+b 和 b+c+a
        //如果两个不相交 都会走过 a+b+2c 最后都为null
        while(A != B){
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }
}
// @lc code=end

