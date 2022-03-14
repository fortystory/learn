package tests.tree;

import data_structures.tree.segmenttree.SegmentTree;

public class TestSegmentTree {
    public static void main(String[] args) throws Exception {

        Integer[] nums = {-2,0,3,-5,2,-1,1,2,3,4,5,6,6,7,8,9,0,11};

        SegmentTree<Integer> segTree = new SegmentTree<>(nums, (a, b) -> a + b);

        System.out.println(segTree);
        System.out.println(segTree.query(0,2));
        System.out.println(segTree.query(2,5));
        System.out.println(segTree.query(0,5));
        System.out.println(segTree.query(0,(nums.length - 1)/2));
        for (int i = 0; i < nums.length; i++) {
            segTree.set(i,1);
        }

        System.out.println(segTree);
    }
}