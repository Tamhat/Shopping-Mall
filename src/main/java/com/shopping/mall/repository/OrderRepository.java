package com.shopping.mall.repository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order entity);
    Optional<Order> findById(String id);
    List<Order> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
