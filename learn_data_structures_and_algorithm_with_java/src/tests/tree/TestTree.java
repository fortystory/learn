package tests.tree;
import data_structures.tree.BST;
import data_structures.tree.BSTBase;
public class TestTree {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        BST<Integer> b = new BSTBase<>();

        int[] nums = {5,10,8,9,1,0,3,8,11,7,4,2};

        for (int num : nums) {
            b.add(num);
        }

        System.out.println(b.maxmum());
        // b.inOrder();
        // System.out.println();
        // b.remove(6);
        // b.inOrder();
        // System.out.println();
        // b.remove(8);
        // b.inOrder();
        // b.preOrder();
        // System.out.println();
        // b.preOrderNR();
        // System.out.println();
        // b.inOrder();
        // b.levelOrder();
        // System.out.println(b.contains(8));
        // System.out.println(b.maxmum());

//         StringBuilder str = new StringBuilder();

// str.append("                                                       ┌───┐\n")
//    .append("                                                       │160│\n")
//    .append("                         ┌───┬─────────────────────────┴───┴─────────────────────────┬───┐\n")
//    .append("                         │ 80│                                                       │ 24│\n")
//    .append("          ┌───┬──────────┴───┴──────────┬───┐                         ┌───┬──────────┴───┴──────────┬───┐\n")
//    .append("          │ 40│                         │ 12│                         │ 20│                         │ 28│\n")
//    .append("   ┌───┬──┴───┴──┬───┐           ┌───┬──┴───┴──┬───┐           ┌───┬──┴───┴──┬───┐           ┌───┬──┴───┴──┬───┐\n")
//    .append("   │ 20│         │ 60│           │ 10│         │ 14│           │ 18│         │ 22│           │ 26│         │ 30│\n")
//    .append("┌──┴┬─┬┴──┐   ┌──┴┬─┬┴──┐     ┌──┴┬─┬┴──┐   ┌──┴┬─┬┴──┐     ┌──┴┬─┬┴──┐   ┌──┴┬─┬┴──┐     ┌──┴┬─┬┴──┐   ┌──┴┬─┬┴──┐\n")
//    .append("│ 10│ │ 30│   │ 50│ │ 7 │     │ 9 │ │ 11│   │ 13│ │ 15│     │ 17│ │ 19│   │ 21│ │ 23│     │ 25│ │ 27│   │ 29│ │ 31│\n")
//    .append("└───┘ └───┘   └───┘ └───┘     └───┘ └───┘   └───┘ └───┘     └───┘ └───┘   └───┘ └───┘     └───┘ └───┘   └───┘ └───┘\n");

//     System.out.println(str.toString());


//     int n = 233333;
//     // System.out.println(Integer.toString(n).length());
//     int max_length = Integer.toString(n).length();

//     Array<String> root_box    = new Array<>();
//     Array<String> branch_box  = new Array<>();
//     Array<String> levaves_box = new Array<>();
//     root_box.addLast("┌─────┐");
//     root_box.addLast("│"+n+"│");

//     System.out.println(root_box);
    }

    // public String fillchar(String str,char fill_char){
    //     return str;
    // }
}
