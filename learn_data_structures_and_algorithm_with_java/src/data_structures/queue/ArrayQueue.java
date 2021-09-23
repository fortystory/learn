package data_structures.queue;
import data_structures.array.Array;
public class ArrayQueue<E> implements Queue<E>{

    private Array<E> array;

    public ArrayQueue(int capcity){
        array = new Array<>(capcity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    /**
     * 获取容量
     * @return
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 入队
     */
    public void enqueue(E e){
        array.addLast(e);;
    }

    /**
     * 出队 O(n)
     */
    public E dequeue(){
        return array.removeFirst();
    }

    public E getFront(){
        return array.getFirst();
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue:front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail.");
        return res.toString();
    }
}
