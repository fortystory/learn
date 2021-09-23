package data_structures.union_find;

/**
 * 并查集
 */
public class UFV2 implements UF{
    private int[] parent;

    public UFV2(int size){
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;//每个节点都指向自己
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
        
        parent[p_root] = q_root;
        return;
    }
}
