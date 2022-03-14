package data_structures.tree.bst;

/**
 * 栈接口
 * 
 * @param <E>
 */
public interface BST<E> {
    /**
     * 查看栈大小
     * 
     * @return
     */
    int getSize();

    /**
     * 栈是否为空
     * 
     * @return
     */
    boolean isEmpty();

    /**
     * 添加元素
     * @param e
     */
    void add(E e);

    /**
     * 是否存在元素e
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 前序遍历 深度优先
     */
    void preOrder();

    /**
     * 中序遍历 深度优先 从小到大顺序输出
     */
    void inOrder();

    /**
     * 后序遍历
     */
    void postOrder();

    /**
     * 层序遍历 广度优先
     */
    void levelOrder();

    /**
     * @return 返回最大元素
     */
    E maxmum();

    /**
     * 删除最大元素
     * @return
     */
    E removeMax();

    /**
     * 找到最小元素是
     * @return
     */
    E minmum();

    /**
     * 删除最小元素
     * @return
     */
    E removeMin();

    /**
     * 删除任意元素
     */
    void remove(E e);
}