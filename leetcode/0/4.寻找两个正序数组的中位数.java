/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * 执行用时：2 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：39.7 MB, 在所有 Java 提交中击败了55.35% 的用户
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] m = new int[l1+l2];
        int i = l1 + l2 - 1;;

        int j = l1 - 1;
        int k = l2 - 1;
        while(j > -1 || k > -1){
            if(k < 0){
                m[i] = nums1[j];
                j--;
            }else if(j < 0){
                m[i] = nums2[k];
                k--;
            }else if(nums1[j] < nums2[k]){
                m[i] = nums2[k];
                k--;
            }else{
                m[i] = nums1[j];
                j--;
            }
            i--;
        }
        double d = 0;
        int helf_m = m.length/2;
        if(m.length%2 == 0){
            d = (m[helf_m - 1] + m[helf_m])/2.0;
        }else{
            d = m[helf_m];
        }

        return d;
    }
}
// @lc code=end

