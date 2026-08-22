package com.shopping.mall.controller;

import com.shopping.mall.entity.Rating;
import com.shopping.mall.repository.RatingRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingRepository ratingRepository;

    @GetMapping
    public ResponseEntity<List<Rating>> getAll() {
        return ResponseEntity.ok(ratingRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getById(@PathVariable String id) {
        return ratingRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Rating> create(@Valid @RequestBody Rating entity) {
        Rating savedEntity = ratingRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rating> update(@PathVariable String id, @Valid @RequestBody Rating entity) {
        if (!ratingRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Rating updatedEntity = ratingRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!ratingRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ratingRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
