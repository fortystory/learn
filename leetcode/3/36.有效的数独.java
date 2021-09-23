/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {

    }

    char[] arr = new char[9];for(
    int i = 0;i<9;i++)
    {
        // 检查行
        for (int j = 0; j < 9; j++) {
            arr[j] = board[i][j];
        }
        if (!check(arr)) {
            return false;
        }
        // 检查列
        for (int j = 0; j < 9; j++) {
            arr[j] = board[j][i];
        }
        if (!check(arr)) {
            return false;
        }
    }

    // 每个宫内的坐标为中心坐标±1
    // [1,1] [1,4] [1,7]
    // [1,4] [4,4] [4,7]
    // [1,7] [7,4] [7,7]
    int[] xy = { 1, 4, 7 };// 中心坐标都是1,4,7组成
    for(
    int i = 0;i<3;i++)
    {
        for (int j = 0; j < 3; j++) {
            arr = getBox(board, xy[i], xy[j]);
            if (!check(arr)) {
                return false;
            }
        }
    }return true;
    }

    // 检查数据中是否存在重复元素
    private boolean check(char[] arr){
        int l = arr.length;
        for (int i = 0; i < l; i++) {
            if(arr[i] == '.'){
                continue;
            }
            //双指针
            for (int j = l - 1; j > -1; j--) {
                if(arr[j] == '.'){
                    continue;
                }
                if(i != j && arr[i] == arr[j]){
                    return false;
                }
            }
        }
        return true;
    }

    // 返回一个宫的九个数字 中心的格子±1
    private char[] getBox(char[][] board,int centerX, int centerY){
        char[] res = new char[9];
        res[0] = board[centerX - 1][centerY - 1];
        res[1] = board[centerX - 1][centerY];
        res[2] = board[centerX - 1][centerY + 1];
        res[3] = board[centerX][centerY - 1];
        res[4] = board[centerX][centerY];
        res[5] = board[centerX][centerY + 1];
        res[6] = board[centerX + 1][centerY - 1];
        res[7] = board[centerX + 1][centerY];
        res[8] = board[centerX + 1][centerY + 1];
        return res;
    }
}
// @lc code=end

