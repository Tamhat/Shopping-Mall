package com.shopping.mall.controller;

import com.shopping.mall.entity.Wishlist;
import com.shopping.mall.repository.WishlistRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wishlists")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistRepository wishlistRepository;

    @GetMapping
    public ResponseEntity<List<Wishlist>> getAll() {
        return ResponseEntity.ok(wishlistRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wishlist> getById(@PathVariable String id) {
        return wishlistRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Wishlist> create(@Valid @RequestBody Wishlist entity) {
        Wishlist savedEntity = wishlistRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wishlist> update(@PathVariable String id, @Valid @RequestBody Wishlist entity) {
        if (!wishlistRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Wishlist updatedEntity = wishlistRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!wishlistRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        wishlistRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
