package com.shopping.mall.controller;

import com.shopping.mall.entity.Inventory;
import com.shopping.mall.repository.InventoryRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventorys")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    @GetMapping
    public ResponseEntity<List<Inventory>> getAll() {
        return ResponseEntity.ok(inventoryRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getById(@PathVariable String id) {
        return inventoryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Inventory> create(@Valid @RequestBody Inventory entity) {
        Inventory savedEntity = inventoryRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> update(@PathVariable String id, @Valid @RequestBody Inventory entity) {
        if (!inventoryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Inventory updatedEntity = inventoryRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!inventoryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        inventoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
