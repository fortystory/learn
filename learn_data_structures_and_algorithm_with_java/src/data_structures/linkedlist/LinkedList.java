package data_structures.linkedlist;
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        // public Node(E e){
        //     this(e,null);
        // }

        // public Node(){
        //     this(null,null);
        // }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size; //元素个数

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // /**
    //  * 在链表头部添加元素
    //  */
    // public void addFirst(E e){
    //     // Node node = new Node(e);
    //     // node.next = head;
    //     // head = node;

    //     head = new Node(e);
    //     size ++;
    // }

    /**
     * 在索引位置添加元素
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("LinedList add fail index illegal.");
        }

        Node prev = dummyHead;//prev是插入节点的前一个节点,这里先赋值给头节点,在遍历找到prev的位置()
        for (int i = 0; i < index; i++) {
            prev = prev.next;//每循环一次,将prev指向它的next节点一次
        }

        // Node node = new Node(e);
        // node.next = prev.next;
        // prev.next = node;
        prev.next = new Node(e,prev.next);

        size ++;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size, e);
    }

    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("LinedList get fail index illegal.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    public void set(int index,E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("LinedList set fail index illegal.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("LinedList remove fail index illegal.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        res.append("LinkedList:");
        for(Node cur = dummyHead.next; cur != null; cur = cur.next){
            res.append(cur.e + "->");
        }
        res.append("null");
        return res.toString();
    }
}
