package tests.map;

import data_structures.map.*;

import java.util.ArrayList;

import tools.FileOperation;

public class DiffMap {
    public static void main(String[] args) throws Exception {
        BSTMap<String,Integer> bstMap = new BSTMap<>();
        LinkedListMap<String,Integer> linkedListMap = new LinkedListMap<>();
        String filename = "src/tools/books/pride-and-prejudice.txt";

        System.out.println("bstSet use:" + testSet(bstMap, filename) + "s");
        System.out.println("linkedListSet use:" + testSet(linkedListMap, filename) + "s");
    }

    private static double testSet(Map<String, Integer> map, String filename) {
        long starTime = System.nanoTime();

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total Words: " + words.size());

            for (String word : words) {
                if(map.contains(word)){
                    map.add(word,map.get(word) + 1);
                }else{
                    map.add(word,1);
                }
            }

            System.out.println("Total different words: " + map.getSize());
        }
        long endTime = System.nanoTime();

        return (endTime - starTime) / 1000000000.0;
    }
}
