package io.pivotal.bookshop.dao;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;

import io.pivotal.bookshop.domain.BookMaster;

public class BookMasterDAO extends DAOCommon<Integer, BookMaster> {
    // The region object that stores BookMaster objects
    private Region<Integer, BookMaster> books;

    public BookMasterDAO(ClientCache cache) {
        super(cache);
        this.books = cache.getRegion("BookMaster");
    }



}
