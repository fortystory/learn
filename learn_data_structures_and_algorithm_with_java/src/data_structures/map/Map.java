package data_structures.map;

public interface Map<K, V> {
    void add(K key,V vvalue);
    V remove(K key);
    boolean contains(K key);//是否存在键key
    V get(K key);
    void set(K key,V newValue);
    int getSize();
    boolean isEmpty();
}
