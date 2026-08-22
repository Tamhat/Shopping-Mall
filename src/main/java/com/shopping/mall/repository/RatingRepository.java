package com.shopping.mall.repository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository {
    Rating save(Rating entity);
    Optional<Rating> findById(String id);
    List<Rating> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
