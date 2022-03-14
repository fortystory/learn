package data_structures.union_find;

public interface UF {
    int getSize();
    /**
     * p q 是否链接
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);
     /**
      * 链接两个元素 
      * @param p
      * @param q
      */
    void unionElements(int p, int q);
}