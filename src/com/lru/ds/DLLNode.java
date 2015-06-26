package com.lru.ds;

public class DLLNode<K,V> {
	private K key;
	private V val;
	private DLLNode<K,V> pre;
	private DLLNode<K,V> next;
 
	public V getVal() {
		return val;
	}

	public void setVal(V val) {
		this.val = val;
	}

	public DLLNode<K,V> getPre() {
		return pre;
	}

	public void setPre(DLLNode<K,V> pre) {
		this.pre = pre;
	}

	public DLLNode<K,V> getNext() {
		return next;
	}

	public void setNext(DLLNode<K,V> next) {
		this.next = next;
	}

	public DLLNode(K key, V value) {
		this.key = key;
		this.val = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}
}