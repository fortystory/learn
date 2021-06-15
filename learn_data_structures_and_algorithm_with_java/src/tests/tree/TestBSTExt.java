package tests.tree;

import data_structures.tree.BST;
import data_structures.tree.BSTExt;

public class TestBSTExt {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        BST<Integer> b = new BSTExt<>();

        int[] nums = {5,10,8,9,1,0,3,8,8,8,8,11,7,4,2};
        // int[] nums = {41,22,58,15,33,50,63,13,37,42,53};

        for (int num : nums) {
            b.add(num);
        }

        // b.preOrder();
        b.inOrder();
        System.out.println();
        b.remove(10);
        b.inOrder();
        // b.postOrder();
        // b.levelOrder();
        // System.out.println(b.contains(10));
        // System.out.println(b.contains(20));
        System.out.println(b.maxmum());
    }
}