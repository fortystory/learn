package tests;
import java.util.Random;

import data_structures.array.Array;
import data_structures.tree.BST;

/**
 * 测试二分搜索书的删除功能
 */
public class TestTreeRemove{
    public static void main(String[] args) throws Exception {
        BST<Integer> b = new BST<>();
        Random random = new Random();
        int n = 100;
        Array<Integer> nums = new Array<>();

        // for (int i = 0; i < n; i++) {
        //     int m = random.nextInt(10000);
        //     b.add(m);
        // }

        // while (!b.isEmpty()) {
        //     nums.addLast(b.removeMax());
        // }

        // for (int i = 0; i < nums.getSize() - 1; i++) { //这里因为要比较 i 和 i+1范围的索引, 如果循环条件限制到 i < nums.getSize() i+1这个下标就越界了
        //     if(!(nums.get(i) > nums.get(i+1))){
        //         throw new IllegalArgumentException("排序出错");
        //     }
        // }

        for (int i = 0; i < n; i++) {
            int m = random.nextInt(10000);
            b.add(m);
        }

        while (!b.isEmpty()) {
            nums.addLast(b.removeMin());
        }

        for (int i = 0; i < nums.getSize() - 1; i++) { // 这里因为要比较 i 和 i+1范围的索引, 如果循环条件限制到 i < nums.getSize() i+1这个下标就越界了
            if (!(nums.get(i) < nums.get(i + 1))) {
                throw new IllegalArgumentException("排序出错");
            }
        }
    }
}
