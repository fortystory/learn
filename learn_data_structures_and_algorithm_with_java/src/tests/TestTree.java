package tests;
import data_structures.tree.BST;
public class TestTree {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        BST<Integer> b = new BST<>();

        int[] nums = { 10,0,8,9,1,5, 3, 6, 8,11,7, 4, 2 };

        for (int num : nums) {
            b.add(num);
        }

        // b.preOrder();
        // System.out.println();
        // b.preOrderNR();
        // System.out.println();
        b.inOrder();
        // System.out.println(b.contains(8));
        // System.out.println(b);
    }
}
