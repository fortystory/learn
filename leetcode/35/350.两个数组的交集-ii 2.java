import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=350 lang=java
 * 执行用时：2 ms, 在所有 Java 提交中击败了91.72% 的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了7.70% 的用户
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> list = new ArrayList<>();
        int j = 0;
        int k = 0;
        while(j < nums1.length && k < nums2.length){
            if(nums1[j] == nums2[k]){
                list.add(nums1[j]);
                j++;
                k++;
            }else if(nums1[j] < nums2[k]){
                j++;
            }else{//nums1[j] > nums2[k]
                k++;
            }
        }

        // 转换成数组
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
// @lc code=end

