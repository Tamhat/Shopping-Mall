package com.shopping.mall.controller;

import com.shopping.mall.entity.Cart;
import com.shopping.mall.repository.CartRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartRepository cartRepository;

    @GetMapping
    public ResponseEntity<List<Cart>> getAll() {
        return ResponseEntity.ok(cartRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getById(@PathVariable String id) {
        return cartRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cart> create(@Valid @RequestBody Cart entity) {
        Cart savedEntity = cartRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> update(@PathVariable String id, @Valid @RequestBody Cart entity) {
        if (!cartRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Cart updatedEntity = cartRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!cartRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cartRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
