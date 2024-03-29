package io.pivotal.bookshop.config;

import io.pivotal.bookshop.domain.InventoryItem;
import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication.Locator;
import org.springframework.data.gemfire.config.annotation.EnablePdx;

import io.pivotal.bookshop.domain.BookMaster;

// TODO-02: Add the appropriate annotation that will both declare this class is a JavaConfiguration class and will 
//          automatically configure the GemFire ClientCache. Also be sure to configure the Locator and optionally set 
//          the log level.

@ClientCacheApplication(logLevel = "info", locators = {
        @Locator()
})

// TODO-05: Add the appropriate annotation to enable PDX Serialization

@EnablePdx
public class GemFireConfiguration {

    // TODO-03: Add the appropriate bean definition to configure the BookMaster Client region as a Proxy region type
    @Bean("BookMaster")
    ClientRegionFactoryBean<Integer, BookMaster> bookMasterRegion(ClientCache clientCache) {
        ClientRegionFactoryBean<Integer, BookMaster> bookMasterRegion = new ClientRegionFactoryBean<>();
        bookMasterRegion.setCache(clientCache);
        bookMasterRegion.setShortcut(ClientRegionShortcut.PROXY);
        return bookMasterRegion;
    }

    @Bean("InventoryItem")
    ClientRegionFactoryBean<Integer, InventoryItem> inventoryItemRegion(ClientCache clientCache) {
        ClientRegionFactoryBean<Integer, InventoryItem> inventoryItemRegion = new ClientRegionFactoryBean<>();
        inventoryItemRegion.setCache(clientCache);
        inventoryItemRegion.setShortcut(ClientRegionShortcut.PROXY);
        return inventoryItemRegion;
    }

}
