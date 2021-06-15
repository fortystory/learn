package data_structures.tree;

import data_structures.queue.LinkedListQueue;
import data_structures.queue.Queue;

/**
 * BST 二分搜索树
 */
public class BSTExt<E extends Comparable<E>> implements BST<E> {

    private class Node {
        public E e;
        public Node left, right;
        public int size; //以该节点为根的元素的数量
        public int depth;//当前元素在树中的深度
        public int count;//相同节点的数量 删除时注意: 如果count > 1减count的数量 count==1 删除节点;添加时++

        public Node(E e) {
            this.e = e;
            left  = null;
            right = null;
            size  = 1;
            depth = 0;
            count = 1;
        }

        @Override
        public String toString(){
            return "[e:"+e+" size:"+size+" depth:"+depth+" count:"+count+"]";
        }
    }

    public Node root; 


    /**
     * 查看栈大小
     * 
     * @return
     */
    @Override
    public int getSize(){
        if(root == null){
            return 0;
        }
        return root.size;
    }

    /**
     * 栈是否为空
     * 
     * @return
     */
    @Override
    public boolean isEmpty(){
        return root.size == 0;
    }

    /**
     * 节点是否为空
     * @param node
     * @return
     */
    private boolean isEmptyNode(Node node){
        return node == null;
    }

    /**
     * 添加元素
     * 
     * @param e
     */
    @Override
    public void add(E e){
        root = add(root,e,0);
    }

    private Node add(Node node, E e, int depth){
        if(isEmptyNode(node)){
            node = new Node(e);
            node.count = 1;
            node.depth = depth;
            node.size = 1;
            return node;
        }else if(node.e.compareTo(e) > 0){
            node.left = add(node.left, e, depth + 1);
        }else if(node.e.compareTo(e) < 0){
            node.right = add(node.right, e,depth + 1);
        }else{ // node.e.compareTo(e) == 0
            node.count++;
        }
        node.size = leftSize(node) + rightSize(node) + 1;//左子树节点数量+右子树节点数量+本身的数量(1)
        return node;
    }

    /**
     * node 左子树的节点数量
     * @param node
     * @return
     */
    private int leftSize(Node node){
        int ls;
        if(node == null){
            ls = 0;
        }else if(node.left == null){
            ls = 0;
        }else{
            ls = node.left.size;
        }
        return ls;
    }

    /**
     * node 右子树的节点数量
     * 
     * @param node
     * @return
     */
    private int rightSize(Node node) {
        int rs;
        if (node == null) {
            rs = 0;
        } else if (node.right == null) {
            rs = 0;
        } else {
            rs = node.right.size;
        }
        return rs;
    }

    /**
     * 是否存在元素e
     * 
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if(node == null){
            return false;
        }else if(node.e.compareTo(e) < 0){
            return contains(node.left,e);
        }else if(node.e.compareTo(e) > 0){
            return contains(node.right,e);
        }else{
            return true;
        }
    }

    /**
     * 前序遍历 深度优先
     */
    @Override
    public void preOrder(){
        System.out.println("preorder:");
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (isEmptyNode(node)) {
            return;
        }
        
        System.out.println("[val:" + node.e + ", size:" + node.size + ", count:" + node.count + ", depth:" + node.depth + "]");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历 深度优先 从小到大顺序输出
     */
    @Override
    public void inOrder(){
        System.out.println("inorder:");
        inOrder(root);
    }

    private void inOrder(Node node){
        if(isEmptyNode(node)){
            return;
        }

        inOrder(node.left);
        System.out.println("[val:"+node.e+", size:"+node.size+", count:"+node.count+", depth:"+node.depth+"]");
        inOrder(node.right);
    }

    /**
     * 后序遍历 深度优先
     */
    @Override
    public void postOrder() {
        System.out.println("postorder:");
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (isEmptyNode(node)) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println("[val:" + node.e + ", size:" + node.size + ", count:" + node.count + ", depth:" + node.depth + "]");
    }
    
    /**
     * 层序遍历 广度优先
     */
    @Override
    public void levelOrder(){
        Queue<Node> q = new LinkedListQueue<>();
        q.enqueue(root);
        while(!q.isEmpty()){
            Node cur = q.dequeue();
            System.out.println("[val:" + cur.e + ", size:" + cur.size + ", count:" + cur.count + ", depth:" + cur.depth + "]");
            if(cur.left != null){
                q.enqueue(cur.left);
            }
            if(cur.right != null){
                q.enqueue(cur.right);
            }
        }
    }

    /**
     * @return 返回最大元素
     */
    @Override
    public E maxmum(){
        if (getSize() == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }
        return maxmum(root).e;
    }
    
    private Node maxmum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxmum(node.right);
    }

    /**
     * 删除最大元素
     * 
     * @return
     */
    @Override
    public E removeMax(){
        E ret = maxmum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            node.size--;
            return leftNode;
        }
        
        node.size--;
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 找到最小元素是
     * 
     * @return
     */
    @Override
    public E minmum(){
        if(getSize() == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }
        return minmum(root).e;
    }

    private Node minmum(Node node){
        if(node.left == null){
            return node;
        }
        return minmum(node.left);
    }

    /**
     * 删除最小元素
     * 
     * @return
     */
    @Override
    public E removeMin(){
        E ret = minmum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根的最小节点
     * 
     * @return 返回删除节点后的二分搜索树的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            node.size--;
            return rightNode;
        }
        node.size--;
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除任意元素
     */
    @Override
    public void remove(E e){
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        return node;
        /*
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { // e.compareTo(node.e) == 0 即需要删除的节点
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                node.size = leftSize(node) + rightSize(node) + 1;
                return rightNode;// 父节点链接新子节点的操作在上面 `node.left = remove(node.left,e);`
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                node.size = leftSize(node) + rightSize(node) + 1;
                return leftNode;// 父节点链接新子节点的操作在上面 `node.right = remove(node.right,e);`
            }
            if(node.count > 1){
                node.count --;
                return node;
            }else{
                // 需要删除的节点 同时拥有左右子树
                // 这里去右子树的最小是作为新的节点
                Node successor = minmum(node.right); // 获取右子树的最小值
                successor.right = removeMin(node.right); // 将最小值删除后赋值给新节点的右子树
                successor.left = node.left; // 左子树平移过来
                successor.size = leftSize(node) + rightSize(node) + 1;
                // 清空删除的节点
                node.left = node.right = null;
                return successor;
            }
        }
        */
    }

    /**
     * 大于 e 的最小值
     * @param e
     * @return
     */
    public E celi(E e){
        return e;
    }

    /**
     * 返回元素e在二分搜索树中的排名
     * @param e
     * @return
     */
    public int rank(E e){
        return 0;
    }

    /**
     * 查找排名第idx的元素
     * @param idx
     * @return
     */
    public E select(int idx){
        return root.e;
    }

    /**
     * 大于 e 的最小值
     * @param e
     * @return
     */
    public E floor(E e){
        return e;
    }

    /**
     * 
     */
    @Override
    public String toString(){
        return "";
    }
}