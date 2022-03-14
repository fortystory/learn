import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=242 lang=java
 * 执行用时：3 ms, 在所有 Java 提交中击败了85.26% 的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了45.53% 的用户
 * 
 * 小写字母数组
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];

        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            idx = s.charAt(i) - 'a';
            map[idx] = map[idx] + 1;
        }

        for (int i = 0; i < t.length(); i++) {
            idx = t.charAt(i) - 'a';
            map[idx] = map[idx] - 1;
        }

        for (int i = 0; i < 26; i++) {
            if(map[i] != 0){
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

