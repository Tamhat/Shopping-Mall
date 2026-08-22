package com.shopping.mall.controller;

import com.shopping.mall.entity.Store;
import com.shopping.mall.repository.StoreRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreRepository storeRepository;

    @GetMapping
    public ResponseEntity<List<Store>> getAll() {
        return ResponseEntity.ok(storeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getById(@PathVariable String id) {
        return storeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Store> create(@Valid @RequestBody Store entity) {
        Store savedEntity = storeRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Store> update(@PathVariable String id, @Valid @RequestBody Store entity) {
        if (!storeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Store updatedEntity = storeRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!storeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        storeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
