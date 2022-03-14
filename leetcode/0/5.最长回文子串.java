/*
 * @lc app=leetcode.cn id=5 lang=java
 * 执行用时：1166 ms, 在所有 Java 提交中击败了5.01% 的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了94.17% 的用户
 * 
 * 假定一个字符串`str[left,right]`是回文字符串
 * 则`str[left + 1,right -1]`也是 否则不是
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int l = s.length();
        if (l == 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        if (l == 2) {
            if (arr[0] == arr[1]) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }
        // int length = 0;
        int start = 0;
        int end = 0;
        int max = 0;
        // System.out.println(isPalindrome(arr,0,l - 1));
        for (int i = 0; i < l; i++) {
            for (int j = l - 1; j > i; j--) {
                if (isPalindrome(arr, i, j)) {
                    if (max < (j - i + 1)) {
                        // System.out.println(i+"-"+j);
                        max = j - i + 1;
                        start = i;
                        end = j;
                        // length = j - i + 1;
                    }
                }
            }
        }
        // System.out.println(s.substring(start, end));
        return s.substring(start, end + 1);
    }

    private boolean isPalindrome(char[] arr, int left, int right) {
        // if (arr[left] != arr[right]) {
        //     return false;
        // }
        // if (left == right) {
        //     return true;
        // }
        // if (left + 1 == right) {
        //     return true;
        // }
        // return isPalindrome(arr, left + 1, right - 1);

        while(true){
            if(arr[left] != arr[right]){
                return false;
            }
            if(left == right || left + 1 == right){
                return true;
            }
            left ++;
            right --;
        }
    }
}
// @lc code=end

