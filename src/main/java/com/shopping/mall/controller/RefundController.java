package com.shopping.mall.controller;

import com.shopping.mall.entity.Refund;
import com.shopping.mall.repository.RefundRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/refunds")
@RequiredArgsConstructor
public class RefundController {

    private final RefundRepository refundRepository;

    @GetMapping
    public ResponseEntity<List<Refund>> getAll() {
        return ResponseEntity.ok(refundRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Refund> getById(@PathVariable String id) {
        return refundRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Refund> create(@Valid @RequestBody Refund entity) {
        Refund savedEntity = refundRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Refund> update(@PathVariable String id, @Valid @RequestBody Refund entity) {
        if (!refundRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Refund updatedEntity = refundRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!refundRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        refundRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
