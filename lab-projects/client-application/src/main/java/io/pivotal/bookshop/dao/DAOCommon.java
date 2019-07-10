package io.pivotal.bookshop.dao;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;

public abstract class DAOCommon<K, T> {
    private ClientCache clientCache;
    private Region<K, T> regions;


    public DAOCommon(ClientCache clientCache,String regionName) {
        this.clientCache = clientCache;
        this.regions= clientCache.getRegion(regionName);
    }

    public void doInsert(K key, T entry) {
        // TODO-06: Write code to insert book with the given key. Use the method that assumes
        //          the entry doesn't already exist
        this.regions.create(key, entry);
    }

    public T doGet(K key) {
        // TODO-07: Write code to get & return a book for the specified key
        return this.regions.get(key);
    }

    public void doUpdate(K key, T entry) {
        // TODO-08: Write code to update book for specified key
        this.regions.replace(key, entry);
    }


    public void doDelete(K key) {
        // TODO-09: Implement delete functionality for specified key
        this.regions.remove(key);
    }


}
