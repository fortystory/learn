import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i : nums) {
            if(map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }else{
                map.put(i,1);
            }
        }

        // PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
        //     @Override
        //     public int compare(Integer a, Integer b){
        //         return map.get(a) - map.get(b);
        //     }
        // });

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int  key : map.keySet()) {
            if(pq.size() < k){
                pq.add(key);
            }else if(map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }

        int[] res = new int[k];
        int idx = 0;
        while(!pq.isEmpty()){
            res[idx] = pq.remove();
            idx++;
        }
        return res;
    }
}
// @lc code=end

