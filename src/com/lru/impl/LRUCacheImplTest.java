package com.lru.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LRUCacheImplTest {
	LRUCacheImpl<String, String> cache;
	
	@Before
	public void setUp() throws Exception {
		cache = new LRUCacheImpl<String, String>(3);
	}

	@Test
	public void testGet() {
		Assert.assertNull(cache.get("hello"));
		//Assert.assertEquals("pranav", cache.get("hello"));
		Assert.assertEquals(true, cache.add("hello", "hello"));
		Assert.assertEquals(true, cache.add("pranav", "pranav"));
		Assert.assertEquals(true, cache.add("flipkart", "flipkart"));
		Assert.assertEquals(true, cache.add("xyz", "pranav"));
		Assert.assertNull(cache.get("hello"));
		Assert.assertEquals("pranav", cache.get("xyz"));
	}

	/*@Test
	public void testAdd() {
		Assert.assertEquals(true, cache.add("hello", "hello"));
		Assert.assertEquals(true, cache.add("pranav", "pranav"));
		Assert.assertEquals(true, cache.add("flipkart", "flipkart"));
		Assert.assertEquals(true, cache.add("hello", "pranav"));
	}

	@Test
	public void testRemove() {
		Assert.assertNull(cache.get("xyz"));
		Assert.assertEquals("pranav", cache.get("hello"));
	}*/

}
