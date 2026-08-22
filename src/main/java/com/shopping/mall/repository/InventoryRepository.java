package com.shopping.mall.repository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository {
    Inventory save(Inventory entity);
    Optional<Inventory> findById(String id);
    List<Inventory> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
