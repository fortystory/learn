package tests.temp;

import java.util.HashMap;
import java.util.TreeMap;

class TimeMap {

    private HashMap<String, TreeMap<Integer, String>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp_query) {
        if (map.get(key) == null) {
            return "";
        }
        if(map.get(key).ceilingKey(timestamp_query) == null){
            return "";
        }
        String res = map.get(key).get(map.get(key).ceilingKey(timestamp_query));
        if (res == null) {
            return "";
        }
        return res;
    }




    public static void main(String[] args) throws Exception {
        TimeMap tm = new TimeMap();
        tm.set("love","high",10);
        tm.set("love","low",20);

        System.err.println(tm.get("love",5));
        System.err.println(tm.get("love",10));
        System.err.println(tm.get("love",15));
        System.err.println(tm.get("love",20));
        System.err.println(tm.get("love",25));
    }
}