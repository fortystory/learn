package data_structures.union_find;

/**
 * 并查集的Quick Find实现 UFv1
 */
public class UFV1 implements UF{
    private int[] id;

    public UFV1(int size){
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize(){
        return id.length;
    }

    private int find(int p){
        if(p < 0 || p >= id.length){
            throw new IllegalArgumentException("index is out of bound.");
        }
        return id[p];
    }

    /**
     * 查看元素p,q是否属于相同的集合 O(1)
     */
    @Override
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    /**
     * 合并元素p,q所属的集合 O(n)
     */
    @Override
    public void unionElements(int p, int q){
        int pid = find(p);
        int qid = find(q);

        if(pid == qid){
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if(id[i] == pid){
                id[i] = qid;
            }
        }
    }
}
