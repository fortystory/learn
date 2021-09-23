import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=217 lang=java
 * 
 * 执行用时：8 ms, 在所有 Java 提交中击败了36.89% 的用户
 * 内存消耗：44.2 MB, 在所有 Java 提交中击败了35.84% 的用户
 *
 * [217] 存在重复元素
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // O(0)
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int n : nums) {
            if(map.containsKey(n)){
                return true;
            }
            map.put(n,0);
        }
        return false;
    }
}
// @lc code=end

