package data_structures.array;
public class Array<E> {

    /** 数组本体 */
    private E[] data;

    /** 有效数据数量 */
    private int size;

    /**
     * 构造函数 创建数组(data)
     * @param capacity 数组长度,数组容量
     */
    @SuppressWarnings("unchecked")
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造方法,默认长度为10
     */
    public Array(){
        this(10);//this() 代表本类的构造方法
    }

    /**
     * 使用数组创建数组
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
     * @return 元素数量
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在数组末尾追加元素
     * @param e 追加的元素
     */
    public void addLast(E e){
        add(size,e);
    }

    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在指定位置插入元素
     * @param index 插入的位置
     * @param e 插入的元素
     */
    public void add(int index, E e){
        if (size >= data.length) {
            // throw new IllegalArgumentException("Add() failed.Array is full.");
            resize(2*data.length);
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add() failed.Requier index < 0 || index > size");
        }
        if(index != size){
            for(int i = size - 1; i >=index; i--){
                data[i + 1] = data[i];
            }
        }
        data[index] = e;
        size ++;
    }

    /**
     * 返回索引处的元素
     * @param index
     * @return 返回索引处的元素
     */
    public E get(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get() failed.Requier index < 0 || index > size");
        }
        return data[index];
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    /**
     * 设置index处元素为e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("set() failed.Requier index < 0 || index > size");
        }
        data[index] = e;
    }

    /**
     * 查找是否存在元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for(int i = 0; i < size; i++){
            if(e.equals(data[i])){
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
    public E remove(int index){
        E ret = data[index];
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove() failed.Requier index < 0 || index > size");
        }
        for(int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;//loitering object != memory leak 闲散对象不同于内存泄漏
        if(size == data.length / 4 && data.length / 2 != 0){ //防止复杂度震荡 预留部分长度
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除一个元素
     * @param e
     * @return
     */
    public boolean removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    public void swap(int i, int j){
        if(i < 0 || j < 0 || i >= size || j >= size){
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
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d,\n       capacity = %d\n", size, data.length));
        res.append("[\n");
        for (int i = 0; i < size; i ++) {
            res.append(String.format("  %d => %s", i, data[i]));
            if(i != size - 1){
                res.append(",\n");
            }
        }
        res.append("\n]");
        return res.toString();
    }

    /**
     * 修改数组容量,实现动态长度
     * @param newCapacity
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}