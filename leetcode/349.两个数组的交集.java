import java.util.ArrayList;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();

        for(int num: nums1){
            set.add(num);//将第一个数组中的元素添加到集合当中 去重
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int num: nums2){
            if(set.contains(num)){//查看第二个数组中的元素是否出现在数组1中
                list.add(num);//将交集元素添加到数组中
                set.remove(num);//删除 这个交集的元素,避免重复记录
            }
        }

        //转换成数组
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
// @lc code=end

