import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=49 lang=java
 * 执行用时：6 ms, 在所有 Java 提交中击败了98.96% 的用户
 * 内存消耗：43.1 MB, 在所有 Java 提交中击败了5.01% 的用户
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    //char[] letter = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> list = new ArrayList<>();
        HashMap<String,ArrayList<String>> m = new HashMap<>();
        String sort_key = "";
        for (String str : strs) {
            sort_key = sort_char(str);
            if(m.containsKey(sort_key)){
                m.get(sort_key).add(str);
            }else{
                ArrayList<String> t = new ArrayList<>();
                t.add(str);
                m.put(sort_key,t);
            }
        }

        for (String k : m.keySet()) {
            ArrayList<String> ls = new ArrayList<>();
            for (String word : m.get(k)) {
                //System.out.println(k+" "+word);
                ls.add(word);
            }
            list.add(ls);
            //System.out.println(k+" "+m.get(k).size());
        }

        return list;
    }

    private String sort_char(String str){
        //System.out.println(str);
        //return str;
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }
}
// @lc code=end

