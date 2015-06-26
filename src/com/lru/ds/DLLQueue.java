package com.lru.ds;

public class DLLQueue<K,V> implements IDLLQueue<K,V>{
	private DLLNode<K,V> head;
	private DLLNode<K,V> rear;
	
	@Override
	public void removeNode(DLLNode<K,V> node) {
		DLLNode<K,V> cur = node;
		DLLNode<K,V> pre = cur.getPre();
		DLLNode<K,V> post = cur.getNext();

		if (pre != null) {
			pre.setNext(post);
		} else {
			head = post;
		}

		if (post != null) {
			post.setPre(pre);
		} else {
			rear = pre;
		}
	}

	@Override
	public void setHead(DLLNode<K,V> node) {
		node.setNext(head);
		node.setPre(null);
		if (head != null) {
			head.setPre(node);
		}

		head = node;
		if (rear == null) {
			rear = node;
		}
	}
	
	@Override
	public K removeRear() {
		if (rear != null) {
			rear.setNext(null);
			return rear.getKey();
		}
		return null;
	}

}