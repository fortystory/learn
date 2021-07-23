/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean need_carry = false; //是否有进位
        int sum = 0;//计算当前位数的和,大于10 need_carry 置为true
        int l1_val = 0;//标记l1.val 为空的话记为0
        int l2_val = 0;

        ListNode sum_node = new ListNode();
        ListNode ret = sum_node;
        while(l1 != null || l2 != null){//如果当前节点有一个不为空则继续
            if(l1 != null){
                l1_val = l1.val;
                l1 = l1.next;//指向下一个节点,用于下次循环
            }else{
                l1_val = 0;
            }

            if(l2 != null){
                l2_val = l2.val;
                l2 = l2.next;
            }else{
                l2_val = 0;
            }

            //计算位数和
            sum = l1_val + l2_val;
            if(need_carry){
                sum = sum + 1;
            }

            need_carry = sum >= 10;//标记是否需要进位
            if(need_carry){
                sum = sum - 10;
            }

            sum_node.val = sum;

            //有一个不为空,创建下一个结点
            if(l1 != null || l2 != null){
                sum_node.next = new ListNode();
                sum_node = sum_node.next;
            }

            //如果都为空但需要进位,添加下个结点
            if(l1 == null && l2 == null && need_carry){
                sum_node.next = new ListNode(1);
            }

        }
        return ret;
    }
}
// @lc code=end

