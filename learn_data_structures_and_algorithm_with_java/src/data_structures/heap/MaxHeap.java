package data_structures.heap;

import data_structures.array.Array;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        // heaify
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * 返回堆中的元素数量
     * @return
     */
    public int size(){
        return data.getSize();
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 返回给定元素父元素的索引
     * @param index
     * @return
     */
    private int parent(int index){
        if(index <= 0){
            throw new IllegalArgumentException("index error!");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子节点对应的索引
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中,一个索引所表示的元素的右孩子节点对应的索引
     * 
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 添加元素
     * @param e
     */
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 调整二叉树的顺序,使其符合父节点的值都大于子节点
     * @param k
     */
    private void siftUp(int k){
        while(k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0){
            data.swap(k,parent(k));
            k = parent(k);
        }
    }

    public E findMax(){
        if(data.isEmpty()){
            throw new IllegalArgumentException("Heap is empty");
        }
        return data.get(0);
    }


    /**
     * 取出堆中最大元素
     * @return
     */
    public E extractMax(){
        E root  = findMax();
        data.set(0,data.getLast());
        data.removeLast();
        siftDown(0);
        return root;
    }

    private void siftDown(int k){
        // while(data.get(k).compareTo(data.get(leftChild(k))) < 0 || data.get(k).compareTo(data.get(rightChild(k))) < 0){ 不能比较两个子节点,可能没有子节点
        while(leftChild(k) < data.getSize()){//如果k节点不存在子节点,则操作完成
            int t = leftChild(k);//如果存在两个子节点,这个t是较大的那个,如果只有左孩子则是左孩子的索引,即如果其大于父节点需要和父节点交换
            if(t + 1 < data.getSize() && data.get(t + 1).compareTo(data.get(t)) > 0){ // t + 1 < data.getSize() => 存在右孩子;  data.get(t + 1).compareTo(data.get(t)) > 0 右孩子比左孩子大
                t = rightChild(k);
            }

            if(data.get(k).compareTo(data.get(t)) >= 0){ //如果父节点比子节点大 无需操作
                break;
            }
            data.swap(k, t); // 如果父节点比最大的子节点小 交换这两个元素的位置
            k = t; // 继续下沉
        }
    }

    /**
     * 取出堆中最大元素并替换为元素e
     * @param e
     * @return
     */
    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }
}
