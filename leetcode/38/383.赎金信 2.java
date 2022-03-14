/*
 * @lc app=leetcode.cn id=383 lang=java
 * 执行用时：1 ms, 在所有 Java 提交中击败了99.94% 的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了52.99% 的用户
 * 
 * 利用小写字母的条件 确定数组大小,若非小写字母 使用map
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int rl = ransomNote.length();
        int ml = magazine.length();
        int[] count = new int[26];// 记录字符出现次数 用于扣除ransomNote中使用的字符,某个字符小于0 则返回false

        char[] r = ransomNote.toCharArray();// 字符串转为数组 比使用charAt() 速度快
        char[] m = magazine.toCharArray();

        for (int i = 0; i < ml; i++) {
            count[m[i] - 'a']++;
        }
        for (int i = 0; i < rl; i++) {
            count[r[i] - 'a']--;
            if (count[r[i] - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

