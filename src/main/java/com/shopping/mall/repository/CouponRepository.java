package com.shopping.mall.repository;

import java.util.List;
import java.util.Optional;

public interface CouponRepository {
    Coupon save(Coupon entity);
    Optional<Coupon> findById(String id);
    List<Coupon> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
