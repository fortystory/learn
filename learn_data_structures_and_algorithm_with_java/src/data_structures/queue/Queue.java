package data_structures.queue;
public interface Queue<E>{

    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 获取队首
     * @return
     */
    E getFront();

    /**
     * 获取数量
     * @return
     */
    int getSize();

    /**
     * 队列是否为空
     * @return
     */
    boolean isEmpty();
}
