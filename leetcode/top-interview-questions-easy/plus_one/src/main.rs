/// [plus_one](https://leetcode-cn.com/problems/plus-one/)
///  给定一个由`整数`组成的`非空`数组所表示的非负整数，在该数的基础上加一。
/// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
/// 你可以假设除了整数 0 之外，这个整数不会以零开头。
/// 
///  
/// 
/// 示例 1：
/// ```
///     输入：digits = [1,2,3]
///     输出：[1,2,4]
///     解释：输入数组表示数字 123。
/// ```
/// 
/// 
/// 示例 2：
/// 
/// ```
///     输入：digits = [4,3,2,1]
///     输出：[4,3,2,2]
///     解释：输入数组表示数字 4321。
/// ```
/// 
/// 
/// 示例 3：
/// 
/// ```
///     输入：digits = [0]
///     输出：[1]
/// ```
///  
/// 提示：
/// ```
///    1 <= digits.length <= 100
///    0 <= digits[i] <= 9
/// ```
/// 
/// 
/// 执行用时：0 ms, 在所有 Rust 提交中击败了100.00% 的用户
/// 内存消耗：1.9 MB, 在所有 Rust 提交中击败了94.50% 的用户
fn main() {
    println!("plus one!");
    let v = vec![9,9];
    let s = Solution::plus_one(v);
    println!("{:?}",s);
}
struct Solution;

impl Solution {
    pub fn plus_one(digits: Vec<i32>) -> Vec<i32> {
        let mut v = digits;
        let mut last = v.len() - 1;
        loop {
            // println!("{}",last);
            v[last] = v[last] + 1;
            if v[last] > 9 {
                v[last] = v[last] - 10;
                if last == 0 {//处理首位进一
                    v.insert(0, 1);
                }
            }else{
                break;
            }

            if last == 0 {
                break;
            }
            last = last - 1;
        }
        v
    }
}