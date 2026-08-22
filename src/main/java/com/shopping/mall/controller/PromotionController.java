package com.shopping.mall.controller;

import com.shopping.mall.entity.Promotion;
import com.shopping.mall.repository.PromotionRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promotions")
@RequiredArgsConstructor
public class PromotionController {

    private final PromotionRepository promotionRepository;

    @GetMapping
    public ResponseEntity<List<Promotion>> getAll() {
        return ResponseEntity.ok(promotionRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promotion> getById(@PathVariable String id) {
        return promotionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Promotion> create(@Valid @RequestBody Promotion entity) {
        Promotion savedEntity = promotionRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promotion> update(@PathVariable String id, @Valid @RequestBody Promotion entity) {
        if (!promotionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Promotion updatedEntity = promotionRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!promotionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        promotionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
