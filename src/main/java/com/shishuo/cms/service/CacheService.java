package com.shishuo.cms.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
	@Autowired
	private SimpleCacheManager cacheManager;
	
	public void cacheClear() {
		Collection<String> cacheNames = cacheManager.getCacheNames();
		for (String cacheName : cacheNames) {
			cacheManager.getCache(cacheName).clear();
		}
	}
}
