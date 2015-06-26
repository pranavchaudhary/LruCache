package com.lru.ds;

public interface IDLLQueue<K, V> {
	void removeNode(DLLNode<K,V> node);
	void setHead(DLLNode<K,V> node);
	K removeRear();
}
