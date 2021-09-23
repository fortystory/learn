import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=118 lang=java
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：36 MB, 在所有 Java 提交中击败了92.86% 的用户
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        //初始化的时候加上<>中的类型,会降低0.5M 从而将内存消耗从击败8% 提升到92.8%
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> level_i = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    level_i.add(1);// numRows 为1,2的时候符合这条
                }else{
                    level_i.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(level_i);
        }
        return list;
    }
}
// @lc code=end

