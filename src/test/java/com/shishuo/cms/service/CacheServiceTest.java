package com.shishuo.cms.service;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class CacheServiceTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private SimpleCacheManager cacheManager;

	@Test
	public void getCache() {
		Collection<String> cacheNames = cacheManager.getCacheNames();
		for (String cacheName : cacheNames) {
			cacheManager.getCache(cacheName).clear();
		}
	}
}
