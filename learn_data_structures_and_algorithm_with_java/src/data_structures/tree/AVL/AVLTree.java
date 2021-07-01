package data_structures.tree.AVL;

import java.util.ArrayList;

import javax.swing.plaf.metal.MetalBorders.InternalFrameBorder;
import javax.swing.plaf.synth.Region;

import org.w3c.dom.Node;

/**
 * 使用带有K,V(可以实现全部的set接口)的BST进行优化得到AVL
 */
public class AVLTree<K extends Comparable<K>, V>{

    /**
     * bst 节点
     */
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;//新的节点默认高度是1 即叶子节点的高度是1
        }
    }



    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size = 0;
    }

    /**
     * 获取节点的高度
     */
    private int getHeithg(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    /**
     * 计算平衡因子
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node){
        if(node == null){
            return 0;
        }
        return getHeithg(node.left) - getHeithg(node.right);
        // return Math.abs(getHeithg(node.left) - getHeithg(node.right));
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
            //新添加的叶子节点使用默认的高度1
            return new Node(key,value);
        }

        if(key.compareTo(node.key) > 0){
            node.right = add(node.right,key,value);
        }else if(key.compareTo(node.key) < 0){
            node.left = add(node.left,key,value);
        }else{
            node.value = value;
        }

        //更新添加后的节点的高度
        node.height = 1+ Math.max(getHeithg(node.left), getHeithg(node.right));

        return rotate(node);
    }

    /**
     * 检查是否是二分搜索树
     */
    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root,keys);
        for (int i = 1; i < keys.size(); i++) {
            if(keys.get(i - 1).compareTo(keys.get(i)) > 0){
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node,ArrayList<K> keys){
        if(node == null){
            return;
        }
        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);
    }

    private Node rotate(Node node){
        //计算平衡因子
        int balance_factor = getBalanceFactor(node);
        // if(Math.abs(balance_factor) > 1){
        //     System.out.print("unblance: "+balance_factor);
        // }

        //树向左倾斜 LL 右旋转 T4 > y > T3 > x > T2 > z > T1
        //          y                     x
        //         / \                  /   \
        //        x   T4   向右旋转y    z     y
        //       / \       ------->   / \   / \
        //      z   T3               T1 T2 T3 T4
        //     / \
        //    T1  T2
        if(balance_factor > 1 && getBalanceFactor(node.left) >= 0){
            return rightRotate(node);//右旋转
        }

        //向右倾斜 RR 左旋转 T4 > z > T3 > x > T2 > y > T1
        //      y                      x
        //     / \     向左旋转y      /   \
        //    T1  x    ------->     y     z
        //       / \               / \   / \
        //      T2  z            T1  T2 T3  T4
        //         / \
        //        T3  T4
        if(balance_factor < -1 && getBalanceFactor(node.right) <= 0){
            return leftRotate(node);//左旋转
        }

        // LR -> LL T4 > y > T3 > z > T2 > x > T1
        //         y                 y                     z
        //        / \               / \                  /   \
        //       x   T4  左旋转x    z   T4   向右旋转y    x     y
        //      / \      ------>  / \       ------->   / \   / \
        //    T1   z             x   T3               T1 T2 T3 T4
        //        / \           / \
        //      T2   T3        T1  T2
        if(balance_factor > 1 && getBalanceFactor(node.left) < 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //RL -> RR  T4 > x > T3 > z > T2 > y > T1
        //    y                y                      z
        //   / \              / \     向左旋转y      /   \
        // T1   x    右旋转x  T1  z    ------->     y     x
        //     / \   ----->     / \               / \   / \
        //    z  T4            T2  x            T1  T2 T3  T4
        //   / \                  / \
        //  T2  T3               T3  T4
        if(balance_factor < -1 && getBalanceFactor(node.right) > 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }


    /**
     * 检查是否是平衡二叉树,即左后子树高度差不大于1
     * @return
     */
    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if(node == null){
            return true;
        }

        int balance_factor = getBalanceFactor(node);

        if(Math.abs(balance_factor) > 1){
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
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
        }

        Node retNode;
        if(node.key.compareTo(key) > 0){
            node.left = remove(node.left,key);
            retNode = node;
        }else if(node.key.compareTo(key) < 0){
            node.right = remove(node.right, key);
            retNode = node;
        }else{
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;// 父节点链接新子节点的操作在上面 `node.left = remove(node.left,e);`
            }else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;// 父节点链接新子节点的操作在上面 `node.right = remove(node.right,e);`
            }else{// 左右都不为空
                // 需要删除的节点 同时拥有左右子树
                // 这里去右子树的最小是作为新的节点
                Node successor = minmum(node.right); // 获取右子树的最小值
                //successor.right = removeMin(node.right); // 将最小值删除后赋值给新节点的右子树
                successor.right = remove(node.right,successor.key); //递归调用自身
                successor.left = node.left; // 左子树平移过来

                // 清空删除的节点
                node.left = node.right = null;
                retNode = successor;
            }
        }
        if(retNode == null){
            return null;
        }

        retNode.height = 1 + Math.max(getHeithg(retNode.left),getHeithg(retNode.right));
        return rotate(retNode);
    }

    private Node minmum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minmum(node.left);
    }

    /**
     * 是否存在键key
     */
    public boolean contains(K key){
        return getNode(root, key) != null;
    }

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

    public  boolean isEmpty(){
        return size == 0;
    }

    // 对节点y进行右旋转操作,返回旋转后的新根节点x
    //          y                     x
    //         / \                  /   \
    //        x   T4   向右旋转y    z     y
    //       / \       ------->   / \   / \
    //      z   T3               T1 T2 T3 T4
    //     / \
    //    T1  T2
    private Node rightRotate(Node y){
        Node x = y.left;
        Node T3 = x.right;

        //旋转
        x.right = y;
        y.left = T3;

        //更新高度,先更新y的高度,再更新x的高度,y现在是x的就子节点
        y.height = Math.max(getHeithg(y.left),getHeithg(y.right)) + 1;
        x.height = Math.max(getHeithg(x.left),getHeithg(x.right)) + 1;

        return x;
    }

    //对y进行左旋转,返回旋转后的节点x
    //      y                      x
    //     / \     向左旋转y      /   \
    //    T1  x    ------->     y     z
    //       / \               / \   / \
    //      T2  z            T1  T2 T3  T4
    //         / \
    //        T3  T4
    private Node leftRotate(Node y){
        Node x = y.right;
        Node T2 = x.left;

        //旋转
        x.left = y;
        y.right = T2;

        //更新高度,先更新y的高度,再更新x的高度,y现在是x的就子节点
        y.height = Math.max(getHeithg(y.left),getHeithg(y.right)) + 1;
        x.height = Math.max(getHeithg(x.left),getHeithg(x.right)) + 1;

        return x;
    }
}