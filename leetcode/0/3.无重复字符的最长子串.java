import java.util.Set;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * 执行用时：54 ms, 在所有 Java 提交中击败了15.72% 的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了21.71% 的用户
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = s.length();//长度为0 直接返回
        if(l == 0){
            return 0;
        }
        int j = 0;
        int max = 1;
        int sl = 0;
        for (int i = 0; i < l - max; i++) {
            // 初始化数据
            j = i + 1;
            set.clear();//清空set
            set.add(s.charAt(i));//添加当前字符
            while(j < l){
                sl = set.size();//记录当前数量
                set.add(s.charAt(j));//添加新元素,set不能存在重复元素
                if(sl == set.size()){//判断新添加的元素是否重复
                    break;//如果重复的话max是添加字符之前的值
                }else{//如果没有重复,更新max值
                    sl = set.size();
                    max = max > sl ? max : sl;
                }
                j++;//下一次循环
            }
        }
        return max;//返回
    }
}
// @lc code=end

