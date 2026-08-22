package com.shopping.mall.repository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    Payment save(Payment entity);
    Optional<Payment> findById(String id);
    List<Payment> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
