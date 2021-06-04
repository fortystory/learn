package tests;
import data_structures.tree.BST;
public class TestTree {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        BST<Integer> b = new BST<>();

        int[] nums = { 5, 3, 6, 8, 4, 2 };

        for (int num : nums) {
            b.add(num);
        }

        // b.preOrder();
        // System.out.println();
        System.out.println();
        b.inOrder();
        System.out.println(b.contains(8));
        // System.out.println(b);
    }
}
