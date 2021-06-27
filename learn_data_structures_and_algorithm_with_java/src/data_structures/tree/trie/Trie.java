package data_structures.tree.trie;

import data_structures.map.BSTMap;
public class Trie {

    private class Node{
        public boolean isWord;
        public BSTMap<Character, Node> next;


        public Node(boolean isWord){
            this.isWord = isWord;
            next = new BSTMap<>();
        }

        public Node(){
            isWord = false;
        }
    }


    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    /**
     * 添加  循环方式
     * @param word
     */
    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.set(c,new Node());
            }
            cur = cur.next.get(c);
        }
        if(!cur.isWord){
            cur.isWord = true;
            size ++;
        }
    }

    // public void add_recursive(String word){
    //     add_recursive(word,0);
    // }

    // private void add_recursive(String word, index idx){
    //     if(idx >= word.length()){

    //     }
    // }

    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }

    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }
}
