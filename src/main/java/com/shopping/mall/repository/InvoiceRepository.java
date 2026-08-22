package com.shopping.mall.repository;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository {
    Invoice save(Invoice entity);
    Optional<Invoice> findById(String id);
    List<Invoice> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
