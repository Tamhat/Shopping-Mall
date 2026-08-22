package com.shopping.mall.repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product entity);
    Optional<Product> findById(String id);
    List<Product> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
