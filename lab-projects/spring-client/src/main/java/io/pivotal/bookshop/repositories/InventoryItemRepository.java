package io.pivotal.bookshop.repositories;

import io.pivotal.bookshop.domain.InventoryItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InventoryItemRepository extends CrudRepository<InventoryItem, Integer> {
    // TODO-16: Define a similar 'findBy' method that looks for items in stock that fall below a threshold

    List<InventoryItem> findByQuantityInStockLessThan(int quantityInStock);
}
