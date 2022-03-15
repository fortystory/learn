

fn main() {
    let nums1:Vec<i32> = vec![4,9,5];
    let nums2:Vec<i32> = vec![9,4,9,8,4];
    let ans:Vec<i32> = Solution::intersect(nums1, nums2);
    println!("{:?}",ans);
}

struct Solution;

impl Solution {

    /// 执行结果：
    /// 通过
    /// 显示详情
    /// 执行用时：328 ms, 在所有 Rust 提交中击败了100.00% 的用户
    /// 内存消耗：2.2 MB, 在所有 Rust 提交中击败了27.59% 的用户
    /// 通过测试用例：56 / 56
    pub fn intersect(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        let mut ans:Vec<i32> = vec![];
        let mut mark1:Vec<usize> = vec![];
        let mut mark2:Vec<usize> = vec![];
        for i in 0..nums1.len() {
            for j in 0..nums2.len() {
                if mark1.contains(&i) || mark2.contains(&j){
                    continue;
                }
                if nums1[i] == nums2[j] {
                    ans.push(nums1[i]);
                    mark1.push(i);
                    mark2.push(j);
                }
            }
        }
        ans
    }
}