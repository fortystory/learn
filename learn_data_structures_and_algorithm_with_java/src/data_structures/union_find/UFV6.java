package data_structures.union_find;

/**
 * 并查集路径压缩到高度为2
 */
public class UFV6 implements UF{
    private int[] parent;
    private int[] rank;//每棵树的层数高度

    public UFV6(int size){
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;//每个节点都指向自己
            rank[i] = 1;
        }
    }

    @Override
    public int getSize(){
        return parent.length;
    }

    //如果从子节点向上找 找到根节点(parent[p] == p)  O(log*n) 近乎于 O(1)
    private int find(int p){
        if(p < 0 || p >= parent.length){
            throw new IllegalArgumentException("index is out of bound.");
        }

        if(p != parent[p]) {
            //使父节点指向树的根节点
            parent[p] = find(parent[p]);//递归 将树的高度压缩到2 将p和他的先祖节点们都指向根节点
        }

        return parent[p];//返回根节点
    }

    /**
     * 查看元素p,q是否属于相同的集合 O(1)
     */
    @Override
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    /**
     * 合并元素p,q所属的集合 O(h) h是树的高度
     */
    @Override
    public void unionElements(int p, int q){
        int p_root = find(p);
        int q_root = find(q);

        if(p_root == q_root)
            return;
        //将层数少的树根指向层数多的树根
        if(rank[p_root] < rank[q_root]){
            parent[p_root] = q_root;//这里不用维护rank[q_root]的值,因为rank[p_root]+1 最多和rank[q_root]相同
        }else if(rank[p_root] > rank[q_root]){
            parent[q_root] = p_root;//这里不用维护rank[p_root]的值,同上
        }else{
            parent[q_root] = p_root;
            rank[p_root] = rank[p_root] + 1;
        }
        return;
    }
}
