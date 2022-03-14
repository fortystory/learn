/*
 * @lc app=leetcode.cn id=73 lang=java
 * 执行用时：1 ms, 在所有 Java 提交中击败了99.53% 的用户
 * 内存消耗：39.8 MB, 在所有 Java 提交中击败了80.93% 的用户
 * 
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> i0 = new ArrayList<Integer>();//记录横向需要置0的坐标
        List<Integer> j0 = new ArrayList<Integer>();//纵向需要置0的坐标
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    i0.add(i);
                    j0.add(j);
                }
            }
        }

        //置0操作
        for (int i : i0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int j : j0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}
// @lc code=end

