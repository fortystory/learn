import java.util.ArrayList;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num)){
                list.add(num);//nums1 中每存在一次记录一次
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0){
                    map.remove(num);
                }
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

