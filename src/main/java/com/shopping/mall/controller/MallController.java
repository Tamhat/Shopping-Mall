package com.shopping.mall.controller;

import com.shopping.mall.entity.Mall;
import com.shopping.mall.repository.MallRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/malls")
@RequiredArgsConstructor
public class MallController {

    private final MallRepository mallRepository;

    @GetMapping
    public ResponseEntity<List<Mall>> getAll() {
        return ResponseEntity.ok(mallRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mall> getById(@PathVariable String id) {
        return mallRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mall> create(@Valid @RequestBody Mall entity) {
        Mall savedEntity = mallRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mall> update(@PathVariable String id, @Valid @RequestBody Mall entity) {
        if (!mallRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Mall updatedEntity = mallRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!mallRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        mallRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
