package tests.set;

import data_structures.set.Set;

import java.util.ArrayList;

import data_structures.set.BSTSet;
import data_structures.set.LinkedListSet;
import data_structures.set.MapSet;
import tools.FileOperation;

public class DiffSet {
    public static void main(String[] args) throws Exception {
        BSTSet<String> bstSet = new BSTSet<>();
        MapSet<String> mapSet = new MapSet<>();
        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        // String filename = "src/tools/books/pride-and-prejudice.txt";
        String filename = "src/tools/books/a-tale-of-two-cities.txt";

        System.out.println("bstSet use:" + testSet(bstSet,filename) + "s");
        System.out.println();
        System.out.println("mapSet use:" + testSet(mapSet,filename) + "s");
        System.out.println();
        System.out.println("linkedListSet use:" + testSet(linkedListSet,filename) + "s");
    }

    private static double testSet(Set<String> set, String filename){
        long starTime = System.nanoTime();

        System.out.println("File: "+filename);

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total Words: " + words.size());

            for (String word : words) {
                set.add(word);
            }

            System.out.println("Total different words: " + set.getSize()  );
        }
        long endTime = System.nanoTime();


        return (endTime - starTime) / 1000000000.0;
    }
}
