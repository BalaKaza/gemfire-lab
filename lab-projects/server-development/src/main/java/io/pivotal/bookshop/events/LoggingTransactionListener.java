package io.pivotal.bookshop.events;

import org.apache.geode.cache.TransactionEvent;
import org.apache.geode.cache.TransactionListener;
import org.apache.geode.cache.util.TransactionListenerAdapter;
import org.apache.geode.internal.logging.LogService;
import org.apache.logging.log4j.Logger;

import java.util.List;

// TODO-05: Make this class extend from TransactionListenerAdapter
// TODO-08: Open the serverCache.xml file in the xml folder (in the server-cluster project) and add configuration 
//         to register this transaction listener
public class LoggingTransactionListener extends TransactionListenerAdapter {

    private Logger logger = LogService.getLogger(LoggingTransactionListener.class.getName());


    // TODO-06: Add an afterCommit method that overrides the adapter method. Write a logger message that notes when a transaction is committed.
    //          Write code that will get the list of events and print the key, old value and new value for each (you can use the code from the
    //          LoggingCacheListener as a guide).

    @Override
    public void afterCommit(TransactionEvent transactionEvent) {
        logger.info("After Commit");
        List events = transactionEvent.getEvents();
        for (Object event : events) {
            System.out.println("Transaction event: " + event.toString());
        }
    }


    // TODO-07: Add an afterRollback method and use the method to log that the rollback occurred.

    @Override
    public void afterRollback(TransactionEvent transactionEvent) {
        logger.info("After Rollback");
        List events = transactionEvent.getEvents();
        for (Object event : events) {
            System.out.println("Transaction event: " + event.toString());
        }
    }

}
