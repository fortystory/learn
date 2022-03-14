/*
 * @lc app=leetcode.cn id=706 lang=java
 *
 * [706] 设计哈希映射
 */

// @lc code=start
import java.util.TreeMap;

class MyHashMap {

    private TreeMap<Integer, Integer>[] hashmap;
    private static final int M = 769;
    private int size;

    /** Initialize your data structure here. */
    public MyHashMap() {
        size = 0;
        hashmap = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashmap[i] = new TreeMap<Integer, Integer>();
        }
    }

    private int hash(int k) {
        return k % M;
    }

    /** value will always be non-negative. */
    public void put(int k, int v) {
        int key = hash(k);
        if(get(k) == -1){
            hashmap[key].put(k,v);
            size ++;
        }else{
            hashmap[key].put(k,v);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int k) {
        int key = hash(k);
        if(hashmap[key].isEmpty()){
            return -1;
        }
        Integer ans = hashmap[key].get(k);
        return ans == null ? -1 : ans;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int k) {
        int key = hash(k);
        if(get(k) != -1){
            hashmap[key].remove(k);
            size --;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end

