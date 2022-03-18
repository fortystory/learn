use std::collections::HashMap;


fn main() {
    println!("two sum");
    let nums:Vec<i32> = vec![3,2,4];
    let target:i32 = 6;
    let ans = Solution::two_sum(nums, target);
    println!("{:?}",ans);
}

struct Solution;


impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut map:HashMap<i32,usize> = HashMap::new();
        for i in 0..nums.len() {
            map.insert(nums[i], i);
        }

        let mut key:i32;

        for j in 0..nums.len() {
            key = target - nums[j];
            if map.contains_key(&key) {
                if map[&key] == j {
                    continue;
                }
                return vec![j as i32,map[&key] as i32];
            }
        }
        vec![]
    }
}