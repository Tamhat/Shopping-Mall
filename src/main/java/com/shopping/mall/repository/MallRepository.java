package com.shopping.mall.repository;

import com.shopping.mall.entity.Mall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MallRepository extends JpaRepository<Mall, String> {
}
