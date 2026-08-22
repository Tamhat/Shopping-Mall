package com.shopping.mall.controller;

import com.shopping.mall.entity.Complaint;
import com.shopping.mall.repository.ComplaintRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/complaints")
@RequiredArgsConstructor
public class ComplaintController {

    private final ComplaintRepository complaintRepository;

    @GetMapping
    public ResponseEntity<List<Complaint>> getAll() {
        return ResponseEntity.ok(complaintRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getById(@PathVariable String id) {
        return complaintRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Complaint> create(@Valid @RequestBody Complaint entity) {
        Complaint savedEntity = complaintRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Complaint> update(@PathVariable String id, @Valid @RequestBody Complaint entity) {
        if (!complaintRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Complaint updatedEntity = complaintRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!complaintRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        complaintRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
