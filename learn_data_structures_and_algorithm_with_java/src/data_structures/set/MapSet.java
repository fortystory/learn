package data_structures.set;

import data_structures.map.BSTMap;
import data_structures.map.Map;

/**
 * 使用映射来实现集合
 */
public class MapSet<E extends Comparable<E>> implements Set<E>{
    public Map<E,Integer> map;

    public MapSet(){
        map = new BSTMap<>();
    }

    @Override
    public void add(E e){
        map.add(e,0);
    }

    @Override
    public boolean contains(E e){
        return map.contains(e);
    };

    @Override
    public void remove(E e){
        map.remove(e);
    }

    @Override
    public int getSize(){
        return map.getSize();
    }

    @Override
    public boolean isEmpty(){
        return map.isEmpty();
    }
}
