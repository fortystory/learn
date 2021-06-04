package data_structures.tree;
/**
 * BST 二分搜索树
 */
public class BST<E extends Comparable<E>>{

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向二分搜索树中添加元素 递归实现
     * @param e
     */
    public void add(E e){
        root = add(root,e); //递归实现
        // add_width_loop(e); //循环实现
    }

    // 我的实现
    // private void add(Node preChild, Node addChild){
    //     if(preChild == null){
    //         preChild = addChild;
    //     }else if (addChild.e.compareTo(preChild.e) < 0) {
    //         if(preChild.left == null){
    //             preChild.left = addChild;
    //             size ++;
    //         }else{  
    //             add(preChild.left, addChild);
    //         }
    //     } else if (addChild.e.compareTo(preChild.e) > 0) {
    //         if (preChild.right == null) {
    //             preChild.right = addChild;
    //             size ++;
    //         } else {
    //             add(preChild.right, addChild);
    //         }
    //     }
    // }


    //递归实现添加元素
    private Node add(Node node, E e){
        if(node == null){
            size++;
            return new Node(e); 
        }
        if(e.compareTo(node.e) < 0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }

    /**
     * 循环实现子节点添加
     * @param e
     * @return
     */
    // private void add_width_loop(E e){
    //     if(root == null){
    //         root = new Node(e);
    //         return;
    //     }else{
    //         Node cur_node = root;
    //         while(true){
    //             if(e.compareTo(cur_node.e) == 0){
    //                 return;
    //             }
    //             if(e.compareTo(cur_node.e) < 0){
    //                 if(cur_node.left == null){
    //                     cur_node.left = new Node(e);
    //                     break;
    //                 }else{
    //                     cur_node = cur_node.left;
    //                 }
    //             }else if(e.compareTo(cur_node.e) > 0){
    //                 if(cur_node.right == null){
    //                     cur_node.right = new Node(e);
    //                     break;
    //                 }else{
    //                     cur_node = cur_node.right;
    //                 }
    //             }
    //         }
    //     }
    //     size++;
    // }


    // public void add_width_loop(E e) {
    //     if (root == null) {
    //         root = new Node(e);
    //         size++;
    //     } else {
    //         Node cur = root;
    //         while (true) {
    //             if (e.equals(cur.e))
    //                 return;
    //             else if (e.compareTo(cur.e) < 0 && cur.left == null) {
    //                 cur.left = new Node(e);
    //                 size++;
    //                 return;
    //             } else if (e.compareTo(cur.e) > 0 && cur.right == null) {
    //                 cur.right = new Node(e);
    //                 size++;
    //                 return;
    //             }

    //             if (e.compareTo(cur.e) < 0)
    //                 cur = cur.left;
    //             else
    //                 cur = cur.right;
    //         }
    //     }
    // }


    // private void add_width_loop(E e) {
    //     if (root == null) {
    //         root = new Node(e);
    //         size++;
    //         return;
    //     }
    //     Node cur_node = root;
    //     boolean is_add = false;
    //     while (!is_add) {
    //         if (e.compareTo(cur_node.e) == 0) {
    //             is_add = true;
    //             return;
    //         }
    //         if (e.compareTo(cur_node.e) < 0) {
    //             if (cur_node.left == null) {
    //                 cur_node.left = new Node(e);
    //                 is_add = true;
    //                 size++;
    //                 return;
    //             } else {
    //                 cur_node = cur_node.left;
    //             }
    //         } else if (e.compareTo(cur_node.e) > 0) {
    //             if (cur_node.right == null) {
    //                 cur_node.right = new Node(e);
    //                 is_add = true;
    //                 size++;
    //                 return;
    //             } else {
    //                 cur_node = cur_node.right;
    //             }
    //         }
    //     }
    // }

    
    // public void add_width_loop(E e) {
    //     if (root == null) {
    //         root = new Node(e);
    //     } else {
    //         Node cur = root;
    //         while (true) {
    //             if (e.compareTo(cur.e) == 0) {
    //                 return;
    //             }
    //             if (e.compareTo(cur.e) > 0) {
    //                 if (cur.right == null) {
    //                     cur.right = new Node(e);
    //                     break;
    //                 } else {
    //                     cur = cur.right;
    //                 }
    //             }
    //             if (e.compareTo(cur.e) < 0) {
    //                 if (cur.left == null) {
    //                     cur.left = new Node(e);
    //                     break;
    //                 } else {
    //                     cur = cur.left;
    //                 }
    //             }
    //         }
    //     }
    //     size++;
    // }


    /**
     * 查询二叉树中是否存在元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if(node == null){
            return false;
        }
        if(node.e.compareTo(e) == 0){
            return true;
        }else if(e.compareTo(node.e) > 0){
            return contains(node.right,e);
        } else { // if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        // pre_order_loop(root);//循环实现
        preOrder(root);
    }


    /**
     * 循环实现前序遍历
     * @param node
     */
    // private void pre_order_loop(Node node){
    //     // Stack stack = new ../Stack/LinkedListStack();
    //     do{
    //         if(node == null){
    //             System.out.println("->null");
    //         }else{

    //         }
    //     }while(true);
    // }

    /**
     * 前序遍历 递归写法
     */
    private void preOrder(Node node){
        if(node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    private void generateBSTString(Node node,int depth,StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString(); 
    }
}