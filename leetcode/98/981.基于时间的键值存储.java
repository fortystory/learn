import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;


/*
 * @lc app=leetcode.cn id=981 lang=java
 * 执行用时：145 ms, 在所有 Java 提交中击败了99.64% 的用户
 * 内存消耗：112.9 MB, 在所有 Java 提交中击败了28.11% 的用户
 * [981] 基于时间的键值存储
 */

// @lc code=start
class TimeMap {

    private HashMap<String,TreeMap<Integer,String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new TreeMap<>());
        }
        //需要操作已经存在的实例,不可以新建
        map.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp_query) {
        TreeMap<Integer,String> t = map.get(key);
        if (t == null) {
            return "";
        }
        //ceilingKey和higherKey 都不合适 foorEntry返回的一个键值对
        Map.Entry<Integer, String> res = t.floorEntry(timestamp_query);
        if (res == null) {
            return "";
        }
        return res.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end

