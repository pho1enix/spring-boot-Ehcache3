package com.phoenix.training.cache.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.cache.event.*;

@Component
public class CacheEventListener implements CacheEntryCreatedListener<String, Object>, CacheEntryRemovedListener<String, Object> , CacheEntryExpiredListener<String, Object> {
    private static final Logger LOG = LoggerFactory.getLogger(CacheEventListener.class);

    @Override
    public void onCreated(Iterable<CacheEntryEvent<? extends String, ?>> cacheEntryEvents) throws CacheEntryListenerException {
        cacheEntryEvents.forEach(cacheEntryEvent -> LOG.info("{} created {}", cacheEntryEvent.getSource().getName(), cacheEntryEvent.getKey()));
    }

    @Override
    public void onRemoved(Iterable<CacheEntryEvent<? extends String, ?>> cacheEntryEvents) throws CacheEntryListenerException {
        cacheEntryEvents.forEach(cacheEntryEvent -> LOG.info("{} removed {}", cacheEntryEvent.getSource().getName(), cacheEntryEvent.getKey()));
    }

    @Override
    public void onExpired(Iterable<CacheEntryEvent<? extends String, ?>> cacheEntryEvents) throws CacheEntryListenerException {
        cacheEntryEvents.forEach(cacheEntryEvent -> LOG.info("{} removed {}", cacheEntryEvent.getSource().getName(), cacheEntryEvent.getKey()));
    }
}
