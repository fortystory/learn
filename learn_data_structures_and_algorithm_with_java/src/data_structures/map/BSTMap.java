package data_structures.map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V>{

    /**
     * bst 节点
     */
    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }



    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }
    
    public void add(K key, V value){
        root = add(root,key,value);
    }

    /**
     * 返回插入新节点后的二分查找树的根
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node,K key, V value){
        if(node == null){
            size++;
            return new Node(key,value);
        }

        if(key.compareTo(node.key) > 0){
            node.right = add(node.right,key,value);
        }else if(key.compareTo(node.key) < 0){
            node.left = add(node.left,key,value);
        }else{
            node.value = value;
        }

        return node;
    }


    /**
     * 返回 node 中key所在的节点
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node,K key){
        if(node == null){
            return null;
        }

        if(node.key.compareTo(key) == 0){
            return node;
        }else if(key.compareTo(node.key) < 0){
            return getNode(node.left, key);
        }else{
            return getNode(node.right, key);
        }
    }

    public V remove(K key){
        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){
        if(node == null){
            return null;
        }else if(node.key.compareTo(key) > 0){
            node.left = remove(node.left,key);
            return node;
        }else if(node.key.compareTo(key) < 0){
            node.right = remove(node.right, key);
            return node;
        }else{
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;// 父节点链接新子节点的操作在上面 `node.left = remove(node.left,e);`
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;// 父节点链接新子节点的操作在上面 `node.right = remove(node.right,e);`
            }
            // 需要删除的节点 同时拥有左右子树
            // 这里去右子树的最小是作为新的节点
            Node successor = minmum(node.right); // 获取右子树的最小值
            successor.right = removeMin(node.right); // 将最小值删除后赋值给新节点的右子树
            successor.left = node.left; // 左子树平移过来

            // 清空删除的节点
            node.left = node.right = null;
            return successor;
        }
    }

    private Node minmum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minmum(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 是否存在键key
     */
    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    @Override
    public  V get(K key){
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public  void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null){
            throw new IllegalArgumentException(key + " key not exist!");
        }
        node.value = newValue;
    }

    public  int getSize(){
        return size;
    }

    @Override
    public  boolean isEmpty(){
        return size == 0;
    }
}
 