package com.shopping.mall.repository;

import java.util.List;
import java.util.Optional;

public interface CartRepository {
    Cart save(Cart entity);
    Optional<Cart> findById(String id);
    List<Cart> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
