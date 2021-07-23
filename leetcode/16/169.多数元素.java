/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        //摩尔投票法
        int vote = 0;//得票数
        int candidate = 0;//候选人
        for(int n: nums){
            //如果票数为0 更改当前为候选人
            if(vote == 0){
                candidate = n;
            }
            //下一个与当前相同得票数加1 反之减1
            if(candidate == n){
                vote ++;
            }else{
                vote --;
            }
        }
        //因为一定有超过一半的元素,这个最后的候选人当选
        //如果不一定存在过半的元素,则需要其他处理
        return candidate;
    }
}
// @lc code=end

