package com.lru.impl;

import java.util.HashMap;
import java.util.Map;

import com.lru.ILRUCache;
import com.lru.ds.DLLNode;
import com.lru.ds.DLLQueue;
import com.lru.ds.IDLLQueue;

public class LRUCacheImpl<K, V> implements ILRUCache<K, V> {
	private int MAX_SIZE;
	private IDLLQueue<K,V> dllQueue;
	private Map<K, DLLNode<K,V>> lruMap;
	private volatile int curSize;

	public LRUCacheImpl(int size) {
		MAX_SIZE = size;
		lruMap = new HashMap<K, DLLNode<K,V>>(size);
		dllQueue = new DLLQueue<K,V>();
		curSize = 0;
	}

	@Override
	public synchronized V get(K key) {
		if (lruMap.containsKey(key)) {
			DLLNode<K,V> tmp = lruMap.get(key);
			dllQueue.removeNode(tmp);
			dllQueue.setHead(tmp);
			return tmp.getVal();
		} else {
			return null;
		}
	}

	

	@Override
	public synchronized boolean add(K key, V value) {

		if (lruMap.containsKey(key)) {
			DLLNode<K,V> oldNode = lruMap.get(key);
			oldNode.setVal(value);
			dllQueue.removeNode(oldNode);
			dllQueue.setHead(oldNode);
		} else {
			DLLNode<K,V> newNode = new DLLNode<K,V>(key,value);
			if (curSize < MAX_SIZE) {
				dllQueue.setHead(newNode);
				lruMap.put(key, newNode);
				curSize++;
			} else {
				lruMap.remove(dllQueue.removeRear());
				dllQueue.setHead(newNode);
				lruMap.put(key, newNode);
			}
		}
		return true;
	}

	@Override
	public synchronized V remove(K key) {
		DLLNode<K,V> tmp = lruMap.get(key);
		if(tmp != null) {
			dllQueue.removeNode(tmp);
			lruMap.remove(key);
			curSize--;
			return tmp.getVal();
		} else {
			return null;
		}

	}

}
