package data_structures.set;

import data_structures.tree.bst.BST;
import data_structures.tree.bst.BSTBase;

public class BSTSet<E extends Comparable<E>> implements Set<E> {
    public BST<E> bst;
    
    public BSTSet(){
        bst = new BSTBase<>();
    }

    @Override
    public void add(E e){
        bst.add(e);
    }

    @Override
    public boolean contains(E e){
        return bst.contains(e);
    }

    @Override
    public void remove(E e){
        bst.remove(e);
    }

    @Override
    public int getSize(){
        return bst.getSize();
    }

    @Override
    public boolean isEmpty(){
        return bst.isEmpty();
    }
}
