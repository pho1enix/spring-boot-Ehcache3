package com.phoenix.training.cache.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.stereotype.Component;

import javax.cache.Cache;
import javax.cache.configuration.FactoryBuilder;
import javax.cache.configuration.MutableCacheEntryListenerConfiguration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;

import static java.util.concurrent.TimeUnit.SECONDS;

@Component
public class CachingSetup implements JCacheManagerCustomizer {
    @Autowired
    CacheEventListener cacheEventListener;

    @Override
    public void customize(javax.cache.CacheManager cacheManager) {
        Cache<Object, Object> users = cacheManager.createCache("Users", new MutableConfiguration<>()
                .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 5)))
                .setStoreByValue(false)
                .setStatisticsEnabled(true));
        users.registerCacheEntryListener(new MutableCacheEntryListenerConfiguration(FactoryBuilder.factoryOf(CacheEventListener.class), null, false, true));
    }
}