import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1743 lang=java
 *
 * [1743] 从相邻元素对还原数组
 */

// @lc code=start
class Solution {
    //todo
    public int[] restoreArray(int[][] adj) {
        int l = adj.length;
        if (l == 1) {
            return adj[0];
        }
        int[] n = new int[l + 1];
        Map<Integer, Integer> mark = new HashMap<Integer, Integer>();

        for (int i = 0; i < l; i++) {
            if (mark.containsKey(adj[i][0])) {
                mark.put(adj[i][0], 2);
            } else {
                mark.put(adj[i][0], 1);
            }
            if (mark.containsKey(adj[i][1])) {
                mark.put(adj[i][1], 2);
            } else {
                mark.put(adj[i][1], 1);
            }
        }

        for (int m : mark.keySet()) {
            if (mark.get(m) == 1) {
                n[0] = m;
                break;
            }
        }

        int idx = 0;
        while (idx < l) {
            for (int i = 0; i < l / 2; i++) {
                // System.out.println(i);
                if (adj[i][0] == n[idx]) {
                    n[idx + 1] = adj[i][1];
                    idx++;
                    continue;
                }
                if (adj[i][1] == n[idx]) {
                    n[idx + 1] = adj[i][0];
                    idx++;
                }

                if (adj[l - i - 1][0] == n[idx]) {
                    n[idx + 1] = adj[l - i - 1][1];
                    idx++;
                    continue;
                }
                if (adj[i][1] == n[idx]) {
                    n[idx + 1] = adj[l - i - 1][0];
                    idx++;
                }
            }
        }
        return n;
    }
}
// @lc code=end

