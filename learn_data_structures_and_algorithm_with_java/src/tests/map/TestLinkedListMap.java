package tests.map;

import java.util.ArrayList;

import data_structures.map.LinkedListMap;
import tools.FileOperation;

public class TestLinkedListMap {
    public static void main(String[] args) throws Exception {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("src/tools/books/pride-and-prejudice.txt", words)){
            System.out.println("Total Words: "+words.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for(String word: words){
                if(map.contains(word)){
                    map.set(word, map.get(word) + 1);
                }else{
                    map.add(word, 1);
                }
            }

            System.out.println("Total different words: "+map.getSize());
            System.out.println("Frequency of Pride: "+map.get("pride"));
            System.out.println("Frequency of Prejudice: "+map.get("prejudice"));
        }
    }
}