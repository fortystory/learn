package data_structures.set;

import data_structures.tree.AVL.AVLTree;

public class AVLSet<E extends Comparable<E>> implements Set<E>{
    public AVLTree<E,Object> avl;
    
    public AVLSet(){
        avl = new AVLTree<>();
    }

    @Override
    public void add(E e){
        avl.add(e,null);
    }

    @Override
    public boolean contains(E e){
        return avl.contains(e);
    }

    @Override
    public void remove(E e){
        avl.remove(e);
    }

    @Override
    public int getSize(){
        return avl.getSize();
    }

    @Override
    public boolean isEmpty(){
        return avl.isEmpty();
    }
}
