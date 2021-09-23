package data_structures.set;

import data_structures.linkedlist.LinkedList;

public class LinkedListSet<E> implements Set<E> {
    public LinkedList<E> list;

    public LinkedListSet(){
        list = new LinkedList<>();
    }

    @Override
    public void add(E e){
        if(!list.contains(e)){ //这一步查找是O(n)
            list.addFirst(e); //这一步添加是O(1),整体是O(n)
        }
    }

    @Override
    public boolean contains(E e){
        return list.contains(e);
    }

    @Override
    public void remove(E e){
        list.removeElement(e);
    }

    @Override
    public int getSize(){
        return list.getSize();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
