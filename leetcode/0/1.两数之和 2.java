import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了93.76% 的用户
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> found = new HashMap<>();
        int[] res = new int[2];
        int diff = 0;
        int l = nums.length;
        int j = 0;
        for (int i = 0; i < l; i++) {
            diff = target - nums[i];
            if (found.containsKey(diff) && i != found.get(diff)) {
                res[0] = found.get(diff);
                res[1] = i;
                break;
            }
            found.put(nums[i], i);
            //重复上面一次 从后向前
            j = l - i - 1;//最后的下标是数组长度-1
            diff = target - nums[j];
            if (found.containsKey(diff) && j != found.get(diff)) {
                res[0] = found.get(diff);
                res[1] = j;
                break;
            }
            found.put(nums[j], j);
        }
        return res;
    }
}
// @lc code=end

