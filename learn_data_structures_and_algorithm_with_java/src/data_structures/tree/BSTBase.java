package data_structures.tree;

import data_structures.stack.Stack;
import data_structures.queue.LinkedListQueue;
import data_structures.queue.Queue;
import data_structures.stack.LinkedListStack;

/**
 * BST 二分搜索树
 */
public class BSTBase<E extends Comparable<E>> implements BST<E>{

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTBase() {
        root = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加元素 递归实现
     * 
     * @param e
     */
    @Override
    public void add(E e) {
        root = add(root, e); // 递归实现
        // add_width_loop(e); //循环实现
    }

    // 我的实现
    // private void add(Node preChild, Node addChild){
    // if(preChild == null){
    // preChild = addChild;
    // }else if (addChild.e.compareTo(preChild.e) < 0) {
    // if(preChild.left == null){
    // preChild.left = addChild;
    // size ++;
    // }else{
    // add(preChild.left, addChild);
    // }
    // } else if (addChild.e.compareTo(preChild.e) > 0) {
    // if (preChild.right == null) {
    // preChild.right = addChild;
    // size ++;
    // } else {
    // add(preChild.right, addChild);
    // }
    // }
    // }

    // 递归实现添加元素
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 循环实现子节点添加
     * 
     * @param e
     * @return
     */
    // private void add_width_loop(E e){
    // if(root == null){
    // root = new Node(e);
    // return;
    // }else{
    // Node cur_node = root;
    // while(true){
    // if(e.compareTo(cur_node.e) == 0){
    // return;
    // }
    // if(e.compareTo(cur_node.e) < 0){
    // if(cur_node.left == null){
    // cur_node.left = new Node(e);
    // break;
    // }else{
    // cur_node = cur_node.left;
    // }
    // }else if(e.compareTo(cur_node.e) > 0){
    // if(cur_node.right == null){
    // cur_node.right = new Node(e);
    // break;
    // }else{
    // cur_node = cur_node.right;
    // }
    // }
    // }
    // }
    // size++;
    // }

    // public void add_width_loop(E e) {
    // if (root == null) {
    // root = new Node(e);
    // size++;
    // } else {
    // Node cur = root;
    // while (true) {
    // if (e.equals(cur.e))
    // return;
    // else if (e.compareTo(cur.e) < 0 && cur.left == null) {
    // cur.left = new Node(e);
    // size++;
    // return;
    // } else if (e.compareTo(cur.e) > 0 && cur.right == null) {
    // cur.right = new Node(e);
    // size++;
    // return;
    // }

    // if (e.compareTo(cur.e) < 0)
    // cur = cur.left;
    // else
    // cur = cur.right;
    // }
    // }
    // }

    // private void add_width_loop(E e) {
    // if (root == null) {
    // root = new Node(e);
    // size++;
    // return;
    // }
    // Node cur_node = root;
    // boolean is_add = false;
    // while (!is_add) {
    // if (e.compareTo(cur_node.e) == 0) {
    // is_add = true;
    // return;
    // }
    // if (e.compareTo(cur_node.e) < 0) {
    // if (cur_node.left == null) {
    // cur_node.left = new Node(e);
    // is_add = true;
    // size++;
    // return;
    // } else {
    // cur_node = cur_node.left;
    // }
    // } else if (e.compareTo(cur_node.e) > 0) {
    // if (cur_node.right == null) {
    // cur_node.right = new Node(e);
    // is_add = true;
    // size++;
    // return;
    // } else {
    // cur_node = cur_node.right;
    // }
    // }
    // }
    // }

    // public void add_width_loop(E e) {
    // if (root == null) {
    // root = new Node(e);
    // } else {
    // Node cur = root;
    // while (true) {
    // if (e.compareTo(cur.e) == 0) {
    // return;
    // }
    // if (e.compareTo(cur.e) > 0) {
    // if (cur.right == null) {
    // cur.right = new Node(e);
    // break;
    // } else {
    // cur = cur.right;
    // }
    // }
    // if (e.compareTo(cur.e) < 0) {
    // if (cur.left == null) {
    // cur.left = new Node(e);
    // break;
    // } else {
    // cur = cur.left;
    // }
    // }
    // }
    // }
    // size++;
    // }

    /**
     * 查询二叉树中是否存在元素e
     * 
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.compareTo(e) == 0) {
            return true;
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else { // if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        }
    }

    /**
     * 前序遍历
     */
    @Override
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历 递归写法
     * 
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 循环实现前序遍历
     * 
     * @param node
     */
    public void preOrderNR() {
        Stack<Node> stack = new LinkedListStack<>();
        stack.push(root); // 将根节点压入栈
        while (!stack.isEmpty()) { // 如果栈是空的则表示已经遍历完成
            Node cur = stack.pop(); // 取出当前栈顶元素,执行遍历操作
            System.err.println(cur.e); // 遍历操作

            // 先压入右子树,再压入左子树 出栈的时候就是先左后右 前序遍历
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        ;
    }

    /**
     * 中序遍历
     */
    @Override
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 前序遍历
     */
    @Override
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 前序遍历 递归写法
     * 
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 层序遍历
     */
    @Override
    public void levelOrder() {
        Queue<Node> q = new LinkedListQueue<>();
        q.enqueue(root);
        while (!q.isEmpty()) {
            Node cur = q.dequeue();
            System.out.println(cur.e);
            if (cur.left != null) {
                q.enqueue(cur.left);
            }
            if (cur.right != null) {
                q.enqueue(cur.right);
            }
        }
    }

    /**
     * 获取最大元素的值
     * 
     * @return
     */
    @Override
    public E maxmum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }
        return maxmum(root).e;
    }

    /**
     * 递归获取node为根的最大元素
     * 
     * @param node
     * @return
     */
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
    public E removeMax() {
        E ret = maxmum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 获取二分搜索树的最小值
     * 
     * @return
     */
    public E minmum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }
        return minmum(root).e;
    }

    /**
     * 获取以node为根的最小值
     * 
     * @param node
     * @return
     */
    private Node minmum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minmum(node.left);
    }

    /**
     * 删除最小元素
     *
     * @return
     */
    public E removeMin() {
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
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
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

    /**
     * 带换行的层序遍历
     */
    public void levelOrderWithEnter() {
        Queue<Node> q = new LinkedListQueue<>();
        q.enqueue(root);
        while (!q.isEmpty()) {
            Node cur = q.dequeue();
            System.out.println(cur.e);
            if (cur.left != null) {
                q.enqueue(cur.left);
            }
            if (cur.right != null) {
                q.enqueue(cur.right);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}