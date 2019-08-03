package io.pivotal.bookshop.repositories;

import io.pivotal.bookshop.domain.BookMaster;
import org.apache.geode.cache.query.SelectResults;
import org.apache.geode.cache.query.Struct;
import org.springframework.data.gemfire.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// TODO-11: Open and inspect this Interface and note it extends CrudRepository. What methods does that add?
@Repository
public interface BookMasterRepository extends CrudRepository<BookMaster, Integer> {
    // TODO-15: Add a 'findBy' method that returns all BookMaster entries having a retailCost of more than the value passed in.
    //          HINT: You might have a look at the unit test (SpringRepositoryTests) to see how the method is used.

    List<BookMaster> findByRetailCostGreaterThan(float retailCost);


    // TODO-19: Add a method called findLowStockBooks that returns a list of BookMaster entries and takes a single
    //          argument as an integer for the inventory in stock threshold. Also add the necessary @Query annotation
    //          to tell Spring GemFire how to perform the query
    //          HINT: You can use the initial query used in the query lab but now you can parameterize the comparison value

    @Query("SELECT * FROM /BookMaster b, /InventoryItem i WHERE i.itemNumber = b.itemNumber and i.quantityInStock < $1")
    SelectResults<BookMaster> findLowStockBooks(@Param("threshold") int threshold);

}
