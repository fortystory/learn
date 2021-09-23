import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=83 lang=java
 * 执行用时：1 ms, 在所有 Java 提交中击败了33.32% 的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了5.09% 的用户
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
        HashMap<Integer,Integer> ele = new HashMap<Integer,Integer>();
        ListNode cur = new ListNode();
        ListNode res = new ListNode();
        cur.next = head;
        res.next = head;
        while(cur.next != null){
            if(ele.containsKey(cur.next.val)){
                cur.next = cur.next.next;
            }else{
                ele.put(cur.next.val, 1);
            }
            cur = cur.next;
        }
        return res.next;
    }
}
// @lc code=end

