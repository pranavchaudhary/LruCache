package com.lru;

public interface ILRUCache<K, V> {
	V get(K key);
	boolean add(K key, V value);
	V remove(K key);
}
