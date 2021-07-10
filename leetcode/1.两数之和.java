import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了66.04% 的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了95.19% 的用户
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> found = new HashMap<>();
        int[] res = new int[2];
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if(found.containsKey(diff) && i != found.get(diff)){
                res[0] = found.get(diff);
                res[1] = i;
                break;
            }
            found.put(nums[i],i);
        }
        return res;
    }
}
// @lc code=end

