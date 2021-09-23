/*
 * @lc app=leetcode.cn id=566 lang=java
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：39.5 MB, 在所有 Java 提交中击败了26.01% 的用户
 * 
 * 将数组转为一维数组再转为二维数组,可以通过坐标关系省略创建数组的步骤
 * [566] 重塑矩阵
 */

// @lc code=start
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int h = mat.length;//这个是高度
        int w = mat[0].length;//这个是宽度
        if(w*h != r * c){
            return mat;
        }

        int[][] res = new int[r][c];
        //将二维数组转为一维数组长度是h*w 将其转为二维数组[r,c]
        //第i个元素在[r,c]中的位置
        //除宽度即使所在的高度,
        //对宽度取余即为在某行所在的位置
        for (int i = 0; i < w*h; i++) {
            //在[r,c]中的位置对应到[h,w]中
            res[i/c][i%c] = mat[i/w][i%w];
        }
        return res;
    }
}
// @lc code=end

