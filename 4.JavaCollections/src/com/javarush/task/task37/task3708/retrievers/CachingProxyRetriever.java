package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{
    private LRUCache lruCache;
    private OriginalRetriever originalRetriever;

    public CachingProxyRetriever(Storage storage) {

        originalRetriever = new OriginalRetriever(storage);
        lruCache = new LRUCache(15);

    }


    @Override
    public Object retrieve(long id) {
        Object o = lruCache.find(id);

        if(o == null) {
            o = originalRetriever.retrieve(id);
            lruCache.set(id, o);
        }
        return o;
    }
}
