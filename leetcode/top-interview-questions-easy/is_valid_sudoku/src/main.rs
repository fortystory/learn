fn main() {
    println!("is valid sudoku!");


    let board:Vec<Vec<char>> = vec![
        vec!['5','3','.','.','7','.','.','.','.'],
        vec!['6','.','.','1','9','5','.','.','.'],
        vec!['.','9','8','.','.','.','.','6','.'],
        vec!['8','.','.','.','6','.','.','.','3'],
        vec!['4','.','.','8','.','3','.','.','1'],
        vec!['7','.','.','.','2','.','.','.','6'],
        vec!['.','6','.','.','.','.','2','8','.'],
        vec!['.','.','.','4','1','9','.','.','5'],
        vec!['.','.','.','.','8','.','.','7','9']
    ];
    let board2:Vec<Vec<char>> = vec![
        vec!['9','3','.','.','7','.','.','.','.'],
        vec!['6','.','.','1','9','5','.','.','.'],
        vec!['.','9','8','.','.','.','.','6','.'],
        vec!['8','.','.','.','6','.','.','.','3'],
        vec!['4','.','.','8','.','3','.','.','1'],
        vec!['7','.','.','.','2','.','.','.','6'],
        vec!['.','6','.','.','.','.','2','8','.'],
        vec!['.','.','.','4','1','9','.','.','5'],
        vec!['.','.','.','.','8','.','.','7','9']
    ];

    Solution::is_valid_sudoku(board);
    Solution::is_valid_sudoku(board2);
}


struct Solution;

impl Solution{
    /// 执行用时：4 ms, 在所有 Rust 提交中击败了89.39% 的用户
    ///
    /// 内存消耗：2 MB, 在所有 Rust 提交中击败了57.58% 的用户
    ///
    /// 通过测试用例：507 / 507
    pub fn is_valid_sudoku(board: Vec<Vec<char>>) -> bool {
        for i in 0..9 {
            for j in 0..9 {
                if board[i][j] == '.' {
                    continue;
                }
                // 横向
                for m in (i+1)..9 {
                    if board[m][j] == '.' {
                        continue;
                    }
                    if board[m][j] == board[i][j] {
                        return false;
                    }
                }
                // 纵向
                for n in (j+1)..9 {
                    if board[i][n] == '.' {
                        continue;
                    }
                    if board[i][n] == board[i][j] {
                        return false;
                    }
                }

                //九宫
                if j % 3 == 2 { //即当前在九宫的底边 上面两种已经校验完成
                    continue;
                }
                if j % 3 == 0 { //在九宫上边
                    match i % 3 {
                        0 => if board[i][j] == board[i + 1][j + 1] || board[i][j] == board[i + 1][j + 2] || board[i][j] == board[i + 2][j + 1] || board[i][j] == board[i + 2][j + 2] {
                                return false;
                             },
                        1 => if board[i][j] == board[i - 1][j + 1] || board[i][j] == board[i - 1][j + 2] || board[i][j] == board[i + 1][j + 1] || board[i][j] == board[i + 1][j + 2] {
                                return false;
                            },
                        2 => if board[i][j] == board[i - 1][j + 1] || board[i][j] == board[i - 1][j + 2] || board[i][j] == board[i - 2][j + 1] || board[i][j] == board[i - 2][j + 2] {
                            return false;
                        },
                        _ => {}
                    }
                }
                if j % 3 == 1 { //在九宫中间
                    match i % 3 {
                        0 => if board[i][j] == board[i + 1][j + 1]  || board[i][j] == board[i + 2][j + 1] {
                                return false;
                             },
                        1 => if board[i][j] == board[i - 1][j + 1] ||  board[i][j] == board[i + 1][j + 1] {
                                return false;
                            },
                        2 => if board[i][j] == board[i - 1][j + 1] || board[i][j] == board[i - 2][j + 1] {
                            return false;
                        },
                        _ => {}
                    }
                }
            }
        }
        true
    }
}