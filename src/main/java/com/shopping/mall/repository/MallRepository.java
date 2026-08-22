package com.shopping.mall.repository;

import java.util.List;
import java.util.Optional;

public interface MallRepository {
    Mall save(Mall entity);
    Optional<Mall> findById(String id);
    List<Mall> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
