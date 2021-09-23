/*
 * @lc app=leetcode.cn id=15 lang=java
 * 执行用时：20 ms, 在所有 Java 提交中击败了96.02% 的用户
 * 内存消耗：42.2 MB, 在所有 Java 提交中击败了76.46% 的用户
 * 排序 双指针
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //排序 双指针
        int l = nums.length;
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(nums == null || l < 3){
            return ret;
        }

        Arrays.sort(nums);//排序

        int left = 0;
        int right = 0;
        int sum = 0;
        for (int i = 0; i < l; i++) {
            if(nums[i] > 0){
                break;//排序后 如果当前值大于0 则三个数的和大于0 结束循环
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;//去重
            }
            left = i + 1;//从当前下一位开始加
            right = l - 1;
            while(left < right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> v = new ArrayList<Integer>(3);
                    v.add(nums[i]);
                    v.add(nums[left]);
                    v.add(nums[right]);
                    ret.add(v);
                    while(left < right && nums[left] == nums[left + 1]){
                        left ++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right --;
                    }
                    left ++;
                    right --;
                }else if(sum < 0){
                    left ++;
                }else if(sum > 0){
                    right --;
                }
            }
        }
        return ret;
    }
}
// @lc code=end

