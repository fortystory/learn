import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=242 lang=java
 * 执行用时：17 ms, 在所有 Java 提交中击败了20.91% 的用户
 * 内存消耗：39.2 MB, 在所有 Java 提交中击败了14.98% 的用户
 * 
 * 可以适用于所有字符
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        char c = ' ';
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            c = t.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c) - 1);
                if(map.get(c) < 0){
                    return false;
                }
            }else{
                return false;
            }
        }

        for (char key: map.keySet()) {
            if(map.get(key) != 0){
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

