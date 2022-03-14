import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=217 lang=java
 * 
 *
 * [217] 存在重复元素
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        //没懂
        byte[] mark = new byte[150000];
        for (int i : nums) {
           int j = i/8;
           int k = i%8;
           int check = 1 << k;
           if((mark[j] & check) != 0){
               return true;
           }
           mark[j] |= check;
        }
        return false;
    }
}
// @lc code=end

