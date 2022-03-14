package data_structures.stack;

/**
 * 栈接口
 * @param <E>
 */
public interface Stack<E>{
    /**
     * 查看栈大小
     * @return
     */
    int getSize();

    /**
     * 栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 添加元素
     * @param e
     */
    void push(E e);

    /**
     * 取出元素
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return
     */
    E peek();
}