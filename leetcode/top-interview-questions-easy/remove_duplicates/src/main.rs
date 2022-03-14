// https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
// 删除排序数组中的重复项


fn main() {
    let mut v:Vec<i32> = vec![1,2,2];
    println!("{:?}",v);
    let  l = Solution::remove_duplicates(&mut v);
    println!("{}",l);
    println!("{:?}",v);
}

struct Solution;

impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        if nums.len() < 2 {
            return nums.len() as i32;
        }

        let mut i = 0;
        let mut j = nums.len() - 1;
        let mut len = nums.len() as i32;

        while i < j {
            if i as i32 == len {
                break;
            }
            if nums[i] == nums[i + 1] {
                let mut m = i;
                let n = j;
                while m < n {
                    nums[m] = nums[m + 1];
                    m = m + 1;
                }
                len = len - 1;
                j = j - 1;//循环减一次 防止从后向前比较出现都是最后的数据 导致长度计算错误
                continue;
            }
            
            if nums[j - 1] == nums[j]{
                j = j - 1;
                len = len - 1;//长度减一
                continue
            }
            i = i + 1;
        }
        len
    }
}
