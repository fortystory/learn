import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {

    private class Array<E> {

        /** 数组本体 */
        private E[] data;

        /** 有效数据数量 */
        private int size;

        /**
         * 构造函数 创建数组(data)
         * 
         * @param capacity 数组长度,数组容量
         */
        @SuppressWarnings("unchecked")
        public Array(int capacity) {
            data = (E[]) new Object[capacity];
            size = 0;
        }

        /**
         * 无参数的构造方法,默认长度为10
         */
        public Array() {
            this(10);// this() 代表本类的构造方法
        }

        /**
         * 使用数组创建数组
         * 
         * @param arr
         */
        @SuppressWarnings("unchecked")
        public Array(E[] arr) {
            data = (E[]) new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            size = arr.length;
        }

        /**
         * 获取数组元素个数,数据数量
         * 
         * @return 元素数量
         */
        public int getSize() {
            return size;
        }

        /**
         * 获取数组容量
         * 
         * @return
         */
        public int getCapacity() {
            return data.length;
        }

        /**
         * 数组是否为空
         * 
         * @return 是否为空
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 在数组末尾追加元素
         * 
         * @param e 追加的元素
         */
        public void addLast(E e) {
            add(size, e);
        }

        public void addFirst(E e) {
            add(0, e);
        }

        /**
         * 在指定位置插入元素
         * 
         * @param index 插入的位置
         * @param e     插入的元素
         */
        public void add(int index, E e) {
            if (size >= data.length) {
                // throw new IllegalArgumentException("Add() failed.Array is full.");
                resize(2 * data.length);
            }

            if (index < 0 || index > size) {
                throw new IllegalArgumentException("Add() failed.Requier index < 0 || index > size");
            }
            if (index != size) {
                for (int i = size - 1; i >= index; i--) {
                    data[i + 1] = data[i];
                }
            }
            data[index] = e;
            size++;
        }

        /**
         * 返回索引处的元素
         * 
         * @param index
         * @return 返回索引处的元素
         */
        public E get(int index) {
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("get() failed.Requier index < 0 || index > size");
            }
            return data[index];
        }

        public E getFirst() {
            return get(0);
        }

        public E getLast() {
            return get(size - 1);
        }

        /**
         * 设置index处元素为e
         * 
         * @param index
         * @param e
         */
        public void set(int index, E e) {
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("set() failed.Requier index < 0 || index > size");
            }
            data[index] = e;
        }

        /**
         * 查找是否存在元素e
         * 
         * @param e
         * @return
         */
        public boolean contains(E e) {
            for (int i = 0; i < size; i++) {
                if (e.equals(data[i])) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 查找元素e对应的索引,如果不存在返回-1
         * 
         * @param e
         * @return
         */
        public int find(E e) {
            for (int i = 0; i < size; i++) {
                if (e.equals(data[i])) {
                    return i;
                }
            }
            return -1;
        }

        /**
         * 移除指定索引位置的元素,指定索引后的元素向前移动
         * 
         * @param index
         * @return 删除的元素
         */
        public E remove(int index) {
            E ret = data[index];
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("remove() failed.Requier index < 0 || index > size");
            }
            for (int i = index + 1; i < size; i++) {
                data[i - 1] = data[i];
            }
            size--;
            data[size] = null;// loitering object != memory leak 闲散对象不同于内存泄漏
            if (size == data.length / 4 && data.length / 2 != 0) { // 防止复杂度震荡 预留部分长度
                resize(data.length / 2);
            }
            return ret;
        }

        /**
         * 删除第一个元素
         * 
         * @return
         */
        public E removeFirst() {
            return remove(0);
        }

        /**
         * 删除最后一个元素
         * 
         * @return
         */
        public E removeLast() {
            return remove(size - 1);
        }

        /**
         * 删除一个元素
         * 
         * @param e
         * @return
         */
        public boolean removeElement(E e) {
            int index = find(e);
            if (index != -1) {
                remove(index);
                return true;
            }
            return false;
        }

        public void swap(int i, int j) {
            if (i < 0 || j < 0 || i >= size || j >= size) {
                throw new IllegalArgumentException("index is illegal.");
            }

            E t = data[i];
            data[i] = data[j];
            data[j] = t;
        }

        /**
         * 重写toString方法
         */
        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append(String.format("Array: size = %d,\n       capacity = %d\n", size, data.length));
            res.append("[\n");
            for (int i = 0; i < size; i++) {
                res.append(String.format("  %d => %s", i, data[i]));
                if (i != size - 1) {
                    res.append(",\n");
                }
            }
            res.append("\n]");
            return res.toString();
        }

        /**
         * 修改数组容量,实现动态长度
         * 
         * @param newCapacity
         */
        @SuppressWarnings("unchecked")
        private void resize(int newCapacity) {
            E[] newData = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    private class MaxHeap<E extends Comparable<E>> {
        private Array<E> data;

        public MaxHeap(int capacity) {
            data = new Array<>(capacity);
        }

        public MaxHeap() {
            data = new Array<>();
        }

        public MaxHeap(E[] arr) {
            data = new Array<>(arr);
            // heaify
            for (int i = parent(arr.length - 1); i >= 0; i--) {
                siftDown(i);
            }
        }

        /**
         * 返回堆中的元素数量
         * 
         * @return
         */
        public int size() {
            return data.getSize();
        }

        /**
         * 是否为空
         * 
         * @return
         */
        public boolean isEmpty() {
            return data.isEmpty();
        }

        /**
         * 返回给定元素父元素的索引
         * 
         * @param index
         * @return
         */
        private int parent(int index) {
            if (index <= 0) {
                throw new IllegalArgumentException("index error!");
            }
            return (index - 1) / 2;
        }

        /**
         * 返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子节点对应的索引
         * 
         * @param index
         * @return
         */
        private int leftChild(int index) {
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
         * 
         * @param e
         */
        public void add(E e) {
            data.addLast(e);
            siftUp(data.getSize() - 1);
        }

        /**
         * 调整二叉树的顺序,使其符合父节点的值都大于子节点
         * 
         * @param k
         */
        private void siftUp(int k) {
            while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
                data.swap(k, parent(k));
                k = parent(k);
            }
        }

        public E findMax() {
            if (data.isEmpty()) {
                throw new IllegalArgumentException("Heap is empty");
            }
            return data.get(0);
        }

        /**
         * 取出堆中最大元素
         * 
         * @return
         */
        public E extractMax() {
            E root = findMax();
            data.set(0, data.getLast());
            data.removeLast();
            siftDown(0);
            return root;
        }

        private void siftDown(int k) {
            // while(data.get(k).compareTo(data.get(leftChild(k))) < 0 ||
            // data.get(k).compareTo(data.get(rightChild(k))) < 0){ 不能比较两个子节点,可能没有子节点
            while (leftChild(k) < data.getSize()) {// 如果k节点不存在子节点,则操作完成
                int t = leftChild(k);// 如果存在两个子节点,这个t是较大的那个,如果只有左孩子则是左孩子的索引,即如果其大于父节点需要和父节点交换
                if (t + 1 < data.getSize() && data.get(t + 1).compareTo(data.get(t)) > 0) { // t + 1 < data.getSize() =>
                                                                                            // 存在右孩子; data.get(t +
                                                                                            // 1).compareTo(data.get(t))
                                                                                            // > 0 右孩子比左孩子大
                    t = rightChild(k);
                }

                if (data.get(k).compareTo(data.get(t)) >= 0) { // 如果父节点比子节点大 无需操作
                    break;
                }
                data.swap(k, t); // 如果父节点比最大的子节点小 交换这两个元素的位置
                k = t; // 继续下沉
            }
        }

        /**
         * 取出堆中最大元素并替换为元素e
         * 
         * @param e
         * @return
         */
        public E replace(E e) {
            E ret = findMax();
            data.set(0, e);
            siftDown(0);
            return ret;
        }
    }

    private interface Queue<E> {

        /**
         * 入队
         * 
         * @param e
         */
        void enqueue(E e);

        /**
         * 出队
         * 
         * @return
         */
        E dequeue();

        /**
         * 获取队首
         * 
         * @return
         */
        E getFront();

        /**
         * 获取数量
         * 
         * @return
         */
        int getSize();

        /**
         * 队列是否为空
         * 
         * @return
         */
        boolean isEmpty();
    }

    private class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

        private MaxHeap<E> maxHeap;

        public PriorityQueue() {
            maxHeap = new MaxHeap<>();
        }

        /**
         * 获取优先队列的大小 O(1)
         */
        @Override
        public int getSize() {
            return maxHeap.size();
        }

        /**
         * 入队 O(logn)
         */
        @Override
        public void enqueue(E e) {
            maxHeap.add(e);
        }

        /**
         * 出队 O(logn) 因为出队后需要sift down一次
         */
        @Override
        public E dequeue() {
            return maxHeap.extractMax();
        }

        /**
         * 获取队首元素 O(1)
         */
        @Override
        public E getFront() {
            return maxHeap.findMax();
        }

        /**
         * 是否为空 O(1)
         */
        @Override
        public boolean isEmpty() {
            return maxHeap.isEmpty();
        }
    }

    private class Freq implements Comparable<Freq>{
        int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another){
            if(this.freq < another.freq){
                return 1;
            }else if(this.freq > another.freq){
                return -1;
            }else{
                return 0;
            }
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i : nums) {
            if(map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }else{
                map.put(i,1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int  key : map.keySet()) {
            if(pq.getSize() < k){
                pq.enqueue(new Freq(key,map.get(key)));
            }else if(map.get(key) > pq.getFront().freq){
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }

        int[] res = new int[k];
        int idx = 0;
        while(!pq.isEmpty()){
            res[idx] = pq.dequeue().e;
            idx++;
        }
        return res;
    }
}
// @lc code=end

