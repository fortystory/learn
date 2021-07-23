/*
 * @lc app=leetcode.cn id=1736 lang=java
 *
 * [1736] 替换隐藏数字得到的最晚时间
 */

// @lc code=start
class Solution {
    public String maximumTime(String time) {
        StringBuilder res = new StringBuilder();
        char c = ' ';
        char f = ' ';
        for (int i = 0; i < time.length(); i++) {
            c = time.charAt(i);
            if(c == '?'){
                switch (i) {
                    case 0:
                        if(time.charAt(1) != '?' && time.charAt(1) > '3'){
                            c = '1';
                        }else{
                            c = '2';
                        }
                        break;
                    case 1:
                        if(f == '2'){
                            c = '3';
                        }else{
                            c = '9';
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        c = '5';
                        break;
                    case 4:
                        c = '9';
                        break;
                    default:
                        break;
                }
            }
            if(i == 0){
                f = c;
            }
            res.append(c);
        }
        return res.toString();
    }
}
// @lc code=end

