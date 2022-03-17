use std::vec;

fn main() {
    let mut nums:Vec<i32> = vec![0,1,0,3,12];

    Solution::move_zeroes(&mut nums);
    println!("{:?}",nums);
}

struct Solution;

impl Solution {

    /// 执行结果：
    /// 通过
    /// 显示详情
    /// 执行用时：52 ms, 在所有 Rust 提交中击败了8.42% 的用户
    /// 内存消耗：2.1 MB, 在所有 Rust 提交中击败了100.00% 的用户
    /// 通过测试用例：74 / 74

    pub fn move_zeroes(nums: &mut Vec<i32>) {
        let len:usize = nums.len();
        for i in 0..len {
            if nums[i] == 0 {
                for j in i..len {
                    if nums[j] != 0 {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }
}