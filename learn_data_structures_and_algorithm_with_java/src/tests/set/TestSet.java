package tests.set;

import java.util.ArrayList;

import javax.security.auth.x500.X500Principal;

import data_structures.set.BSTSet;
import data_structures.set.LinkedListSet;
import data_structures.set.MapSet;
import tools.FileOperation;

public class TestSet {
    public static void main(String[] args) throws Exception {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/tools/books/pride-and-prejudice.txt", words)) {
            System.out.println("Total Words: " + words.size());
            MapSet<String> set = new MapSet<>();
            // BSTSet<String> set = new BSTSet<>();
            // LinkedListSet<String> set = new LinkedListSet<>();
            for (String word : words) {
                    set.add(word);
            }

            System.out.println("total different words: " + set.getSize()  );
        }
    }
}
