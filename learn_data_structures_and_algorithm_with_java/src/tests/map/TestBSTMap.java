package tests.map;

import java.util.ArrayList;

import data_structures.map.BSTMap;
import tools.FileOperation;

public class TestBSTMap {
    public static void main(String[] args) throws Exception {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("src/tools/books/pride-and-prejudice.txt", words)){
            System.out.println("Total Words: "+words.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for(String word: words){
                if(map.contains(word)){
                    map.set(word, map.get(word) + 1);
                }else{
                    map.add(word, 1);
                }
            }

            System.out.println("TotalBSTMap different words: "+map.getSize());
            System.out.println("Frequency of Pride: "+map.get("pride"));
            map.set("prejudice",2333);
            System.out.println("Frequency of Prejudice: "+map.get("prejudice"));
            map.remove("prejudice");
            System.out.println("Frequency of Prejudice: "+map.get("prejudice"));
        }
    }
}