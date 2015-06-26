package com.lru.impl;

import com.lru.ILRUCache;

public class DriverMain {

	public static void main(String[] args) {
		ILRUCache<String, String> cache = new LRUCacheImpl<String, String>(3);
		System.out.println(cache.get("pranav"));
		cache.add("pranav", "pranav");
		cache.add("abc", "pranav");
		cache.add("xyz", "pranav");
		System.out.println(cache.get("pranav"));
		System.out.println(cache.add("xyz", "xyz"));
		System.out.println(cache.get("abc"));
		System.out.println(cache.remove("flip"));
		System.out.println(cache.remove("flip"));
	}

}
