package data_structures.set;

import data_structures.tree.trie.Trie;

// todo remove没有实现
public class TrieSet<E extends Comparable<E>> implements Set<E> {
    public Trie bst;
    
    public TrieSet(){
        bst = new Trie();
    }

    @Override
    public void add(E e){
        //bst.add(e);
    }

    @Override
    public boolean contains(E e){
        return false;
        //return bst.contains(e);
    }

    @Override
    public void remove(E e){
        //bst.remove(e);
    }

    @Override
    public int getSize(){
        return bst.getSize();
    }

    @Override
    public boolean isEmpty(){
        return bst.getSize() == 0;
    }
}
