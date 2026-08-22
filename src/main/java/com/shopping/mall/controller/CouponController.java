package com.shopping.mall.controller;

import com.shopping.mall.entity.Coupon;
import com.shopping.mall.repository.CouponRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coupons")
@RequiredArgsConstructor
public class CouponController {

    private final CouponRepository couponRepository;

    @GetMapping
    public ResponseEntity<List<Coupon>> getAll() {
        return ResponseEntity.ok(couponRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coupon> getById(@PathVariable String id) {
        return couponRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Coupon> create(@Valid @RequestBody Coupon entity) {
        Coupon savedEntity = couponRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coupon> update(@PathVariable String id, @Valid @RequestBody Coupon entity) {
        if (!couponRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Coupon updatedEntity = couponRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!couponRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        couponRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
