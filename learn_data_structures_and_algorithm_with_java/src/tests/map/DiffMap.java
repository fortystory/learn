package tests.map;

import data_structures.map.*;

import java.util.ArrayList;

import tools.FileOperation;

public class DiffMap {
    public static void main(String[] args) throws Exception {
        BSTMap<String,Integer> bstMap = new BSTMap<>();
        LinkedListMap<String,Integer> linkedListMap = new LinkedListMap<>();
        AVLMap<String,Integer> avlMap = new AVLMap<>();

        String filename = "src/tools/books/pride-and-prejudice.txt";
        System.out.println(filename);

        System.out.println("bstMap use:" + testMap(bstMap, filename) + "s");
        // System.out.println("linkedListMap use:" + testMap(linkedListMap, filename) + "s");
        System.out.println("avlMap use:" + testMap(avlMap, filename) + "s");
    }

    private static double testMap(Map<String, Integer> map, String filename) {
        long starTime = System.nanoTime();

        //System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.print(" Total Words: " + words.size());

            for (String word : words) {
                if(map.contains(word)){
                    map.add(word,map.get(word) + 1);
                }else{
                    map.add(word,1);
                }
            }
            System.out.print(",Total different words: " + map.getSize()+",");
            for (String word : words) {
                map.remove(word);
            }
        }
        long endTime = System.nanoTime();

        return (endTime - starTime) / 1000000000.0;
    }
}
