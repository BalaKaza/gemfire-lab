package io.pivotal.bookshop.dao;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;

import io.pivotal.bookshop.domain.Customer;

// TODO-11: Implement the appropriate methods of the CustomerDAO class as you did with BookMasterDAO
public class CustomerDAO extends DAOCommon<Integer,Customer> {

	public CustomerDAO(ClientCache clientCache) {
		super(clientCache,"Customers");
	}
}
