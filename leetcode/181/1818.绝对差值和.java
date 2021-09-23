import javax.swing.plaf.synth.Region;

import jdk.internal.module.SystemModuleFinders;

/*
 * @lc app=leetcode.cn id=1818 lang=java
 *
 * [1818] 绝对差值和
 */

// @lc code=start
class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        int n = nums1.length;
        int sum = 0;// 绝对值差的和
        int sub = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        int d = 0;

        int[] sort_nums1 = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            sort_nums1[i] = nums1[i];
        }
        // 排序第一个数组
        quick_sort(sort_nums1);

        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) {
                continue;
            }
            sub = Math.abs(nums1[i] - nums2[i]);
            sum = sum + sub;

            l = 0;
            r = n - 1;
            // 二分搜索
            while (l < r) {
                m = l + (r - l + 1) / 2;
                if (sort_nums1[m] <= nums2[i]) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }

            /*
             * if(sort_nums1[head] > nums2[i]){ mid = sort_nums1[head] - nums2[i]; d =
             * Math.max(d,Math.abs(sub - mid)); }else{ mid = nums2[i] - sort_nums1[head]; d
             * = Math.max(d,Math.abs(sub - mid)); }
             * 
             * if(sort_nums1[tail] > nums2[i]){ mid = sort_nums1[tail] - nums2[i]; d =
             * Math.max(d,Math.abs(sub - mid)); }else{ mid = nums2[i] - sort_nums1[tail]; d
             * = Math.max(d,Math.abs(sub - mid)); }
             */
            int nd = Math.abs(sort_nums1[r] - nums2[i]);
            if (r + 1 < n) {
                nd = Math.min(nd, Math.abs(sort_nums1[r + 1] - nums2[i]));
            }
            if (nd < sub) {
                d = Math.max(d, sub - nd);
            }
            // System.out.println(nums2[i]+" "+sort_nums1[head]+" "+sort_nums1[tail]+" "+d);
        }

        return (sum - d + MOD) % MOD;
    }

    private void quick_sort(int[] arr) {
        quick_sort(arr, 0, arr.length - 1);
    }

    private void quick_sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int temp = 0;
        if (right - left == 1) {
            if (arr[left] > arr[right]) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        int n = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            // j-- 要放在 i++ 之前-_-!!
            // 找到arr[j] < n的位置,如果没有找下一个,上面的i变了需要却表 i < j
            while (arr[j] >= n && i < j) {
                j--;
            }

            // 找到arr[i] > n的位置,如果不大于找下一个
            while (arr[i] <= n && i < j) {
                i++;
            }

            // 替换
            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 用于比较的数组n,对于整个数组来说排序后的位置是i
        arr[left] = arr[i];
        arr[i] = n;
        quick_sort(arr, left, i - 1);
        quick_sort(arr, i + 1, right);
    }
}
// @lc code=end

