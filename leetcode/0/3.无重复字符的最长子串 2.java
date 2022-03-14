import java.util.Set;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * 执行用时：2 ms, 在所有 Java 提交中击败了99.97% 的用户
 * 内存消耗：38.3 MB, 在所有 Java 提交中击败了84.21% 的用户
 * 
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }

        int l = 0;//左边界
        int m = 0;//最长字串长度
        int i = 0;//新字符在滑动窗口中的位置
        //r 右边界
        char c = ' ';
        for (int r = 1; r < s.length(); r++) {
            c = s.charAt(r);
            i = s.indexOf(c,l);//从左边界查询第一次出现的位置
            if(i < r){//重复出现
                m = Math.max(m,r - l);//计算最大长度 记录当前字符串长度和以前字符串长度的最大值
                l = i + 1;//重复字符的下一个
            }
        }
        
        m = Math.max(m,s.length() - l);//计算最大长度 最后的窗口长度 r = s.length();
        return m;
    }
}
// @lc code=end

