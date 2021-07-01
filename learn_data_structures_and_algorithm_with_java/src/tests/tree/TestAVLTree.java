package tests.tree;

import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import data_structures.tree.AVL.AVLTree;
import tools.FileOperation;

public class TestAVLTree {
    public static void main(String[] args) throws Exception {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/tools/books/pride-and-prejudice.txt", words)) {
            System.out.println("Total Words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }



            System.out.println(map.isBST());
            System.out.println(map.isBalanced());
            for(String word: words){
                map.remove(word);
                if(!map.isBST() || !map.isBalanced()){
                    throw new RuntimeException("Error");
                }
            }
            System.out.println("OK");

            //System.out.println("TotalBSTMap different words: " + map.getSize());
            //System.out.println("Frequency of Pride: " + map.get("pride"));
            //System.out.println("Frequency of Prejudice: " + map.get("prejudice"));
            //map.remove("prejudice");
            //System.out.println("Frequency of Prejudice: " + map.get("prejudice"));
        }
    }
}