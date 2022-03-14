/*
 * @lc app=leetcode.cn id=383 lang=java
 * 执行用时：11 ms, 在所有 Java 提交中击败了26.70% 的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了33.34% 的用户
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int rl = ransomNote.length();
        int ml = magazine.length();
        boolean[] markNote = new boolean[rl];
        boolean[] markMagazine = new boolean[ml];

        char[] r = ransomNote.toCharArray();// 字符串转为数组 比使用charAt() 速度快
        char[] m = magazine.toCharArray();

        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < ml; j++) {
                if (markMagazine[j]) {
                    continue;
                }
                if (r[i] == m[j]) {
                    markNote[i] = true;
                    markMagazine[j] = true;
                    break;
                }
            }
        }

        boolean res = markNote[0];
        for (int i = 0; i < rl - 1; i++) {
            res = res && markNote[i] && markNote[i + 1];
        }
        return res;
    }
}
// @lc code=end

