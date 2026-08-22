package com.shopping.mall.repository;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository {
    Notification save(Notification entity);
    Optional<Notification> findById(String id);
    List<Notification> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
