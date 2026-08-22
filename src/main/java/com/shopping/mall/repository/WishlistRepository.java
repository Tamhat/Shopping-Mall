package com.shopping.mall.repository;

import java.util.List;
import java.util.Optional;

public interface WishlistRepository {
    Wishlist save(Wishlist entity);
    Optional<Wishlist> findById(String id);
    List<Wishlist> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
