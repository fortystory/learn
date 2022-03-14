/*
 * @lc app=leetcode.cn id=275 lang=java
 *
 * [275] H 指数 II
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        // 1
        // int n = citations.length;
        // for (int i = 0; i < n; i++) {
        //     // 假设h = n - i,被引用数要大于等于h
        //     if(citations[i] >= n - i){
        //         return n - i;
        //     }
        // }
        // return 0;


        //2
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while(left <= right){
            mid = left + ((right - left) / 2);//计算中间值
            // h = n - mid 
            if(citations[mid] >= n - mid){
                right = mid - 1;//重置右值
            }else{
                left = mid + 1;//重置左值
            }
        }
        return n - left;
    }
}
// @lc code=end

