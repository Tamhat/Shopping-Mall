package com.shopping.mall.repository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository {
    Store save(Store entity);
    Optional<Store> findById(String id);
    List<Store> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
