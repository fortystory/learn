package data_structures.queue;

import data_structures.heap.MaxHeap;

/**
 * 优先队列
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{
    
    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    /**
     * 获取优先队列的大小 O(1)
     */
    @Override
    public int getSize(){
        return maxHeap.size();
    }

    /**
     * 入队 O(logn)
     */
    @Override
    public void enqueue(E e){
        maxHeap.add(e);
    }

    /**
     * 出队 O(logn) 因为出队后需要sift down一次
     */
    @Override
    public E dequeue(){
        return maxHeap.extractMax();
    }

    /**
     * 获取队首元素 O(1)
     */
    @Override
    public E getFront(){
        return maxHeap.findMax();
    }

    /**
     * 是否为空 O(1)
     */
    @Override
    public boolean isEmpty(){
        return maxHeap.isEmpty();
    }
}
