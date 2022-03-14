/*
 * @lc app=leetcode.cn id=88 lang=java
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了95.69% 的用户
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = n - 1;
        int i = m - 1;
        int r = n + m - 1;
        //从后向前添加数据
        //两个数组是有序的
        while(j >= 0 || i >= 0){
            if(i == -1){
                nums1[r] = nums2[j];
                j--;
            }else if(j == -1){
                nums1[r] = nums1[i];
                i--;
            }else if(nums2[j] >= nums1[i]){
                nums1[r] = nums2[j];
                j--;
            }else{
                nums1[r] = nums1[i];
                nums1[i] = 0;
                i--;
            }
            r--;
        }
    }

    /*
    private String pa(int[] arr){
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int n : arr) {
            res.append(n+",");
        }
        res.append("]");
        return res.toString();
    }
    */
}
// @lc code=end

