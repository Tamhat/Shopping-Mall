package com.shopping.mall.repository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Category save(Category entity);
    Optional<Category> findById(String id);
    List<Category> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
