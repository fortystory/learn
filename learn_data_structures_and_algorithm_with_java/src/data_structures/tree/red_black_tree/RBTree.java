package data_structures.tree.red_black_tree;

import java.lang.ProcessBuilder.Redirect;

public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public boolean color; 

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isRed(Node node){
        if(node == null){
            return BLACK; 
        }
        return node.color;
    }

    /** 
     * 2-节点添加新元素
     *   node                   x
     *  /    \      左旋转     /  \
     * T1     x     ----->  node  T3
     *       / \           /    \
     *     T2   T3        T1    T2
     * @param node
     * @return
     */
    private Node leftRotate(Node node){
        Node x = node.right;

        //左旋转
        node.right = x.right;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * 颜色反转
     * 新节点插入到3-节点时[红 - 黑] 会形成一个4-节点[红 - 黑 - 红]然后转换为3个2-节点
     * 这时需要反转3个2-节点的颜色,因为父节点会与他的父节点进行融合,也是一个红节点
     * @param node
     */
    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 3-节点添加元素
     *      node              x
     *     /    \    右旋转   / \
     *    x      T2  ---->  y  node
     *   / \                  /    \
     *  y   T1               T1    T2
     * @param ndoe
     * @return
     */
    private Node rightRotate(Node node){
        Node x = node.left;

        //右旋转
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    // 向红黑树中添加新的元素(key, value)
    public void add(K key, V value){
        root = add(root, key, value);
        root.color = BLACK;//维持根节点为黑色
    }

    // 向以node为根的二分搜索树中插入元素(key, value)，递归算法
    // 返回插入新节点后树的根
    private Node add(Node node, K key, V value){

        if(node == null){
            size ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else // key.compareTo(node.key) == 0
            node.value = value;


        //   [B]       [B]        [B]       [B]           [R]
        //   /  {1}    /   {2}    /  {3}    / \    {4}    / \
        // [R]  -->  [R]   -->  [R]  -->  [R] [R]  -->  [B] [B]
        //             \        /
        //             [R]    [R]    {3}右旋转上面的节点
        //            {2}左旋转中间的节点

        // {2}
        if(isRed(node.right) && !isRed(node.left)){
            node = leftRotate(node);
        }

        // {3}
        if(isRed(node.left) && !isRed(node.left.left)){
            node = rightRotate(node);
        }

        //{4}
        if(isRed(node.left) && isRed(node.right)){
            flipColors(node);
        }

        return node;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key){

        if(node == null)
            return null;

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    public V get(K key){

        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除键为key的节点
    public V remove(K key){

        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){

        if( node == null )
            return null;

        if( key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
            return node;
        }
        else if(key.compareTo(node.key) > 0 ){
            node.right = remove(node.right, key);
            return node;
        }
        else{   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }
}
