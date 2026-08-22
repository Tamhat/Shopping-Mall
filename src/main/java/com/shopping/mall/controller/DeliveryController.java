package com.shopping.mall.controller;

import com.shopping.mall.entity.Delivery;
import com.shopping.mall.repository.DeliveryRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deliverys")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryRepository deliveryRepository;

    @GetMapping
    public ResponseEntity<List<Delivery>> getAll() {
        return ResponseEntity.ok(deliveryRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getById(@PathVariable String id) {
        return deliveryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Delivery> create(@Valid @RequestBody Delivery entity) {
        Delivery savedEntity = deliveryRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Delivery> update(@PathVariable String id, @Valid @RequestBody Delivery entity) {
        if (!deliveryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Delivery updatedEntity = deliveryRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!deliveryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        deliveryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
