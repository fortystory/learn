package data_structures.union_find;

/**
 * 添加size比较
 */
public class UFV3 implements UF{
    private int[] parent;
    private int[] sz;//每棵树节点的数量

    public UFV3(int size){
        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;//每个节点都指向自己
            sz[i] = 1;
        }
    }

    @Override
    public int getSize(){
        return parent.length;
    }

    //如果从子节点向上找 找到根节点(parent[p] == p)
    private int find(int p){
        if(p < 0 || p >= parent.length){
            throw new IllegalArgumentException("index is out of bound.");
        }
        while(p != parent[p]) {
            p = parent[p];
        }
        return p;
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
        //将元素少的合并到元素多的树上,原元素少的树的高度+1即为新树的最低高度
        if(sz[p_root] < sz[q_root]){
            parent[p_root] = q_root;//合并少的树到多的树中
            sz[q_root] = sz[p_root] + 1;//重新设置新树的高度
        }else{
            parent[q_root] = p_root;
            sz[p_root] = sz[q_root] + 1;
        }
        return;
    }
}
