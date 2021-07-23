import java.util.HashSet;
// import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=804 lang=java
 *
 * [804] 唯一摩尔斯密码词
 */

// @lc code=start
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {
            ".-",  //a
            "-...",//b
            "-.-.",//c
            "-..", //d
            ".",   //e
            "..-.",//f
            "--.", //g
            "....",//h
            "..",  //i
            ".---",//j
            "-.-", //k
            ".-..",//l
            "--",  //m
            "-.",  //n
            "---", //o
            ".--.",//p
            "--.-",//q
            ".-.", //r
            "...", //s
            "-",   //t
            "..-", //u
            "...-",//v
            ".--", //w
            "-..-",//x
            "-.--",//y
            "--.." //z
        };
        // TreeSet<String> set = new TreeSet<>();
        HashSet<String> set = new HashSet<>();//hashset比treeset插入时间复杂度低

        for(String word:words){
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i) - 'a']);//所有输入是小写字母,字符加减会按照ASCII码计算,减掉'a'刚好是数组codes的索引
            }
            set.add(res.toString());
        }
        return set.size();
    }
}
// @lc code=end

