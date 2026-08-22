package com.shopping.mall.controller;

import com.shopping.mall.entity.Address;
import com.shopping.mall.repository.AddressRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresss")
@RequiredArgsConstructor
public class AddressController {

    private final AddressRepository addressRepository;

    @GetMapping
    public ResponseEntity<List<Address>> getAll() {
        return ResponseEntity.ok(addressRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable String id) {
        return addressRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Address> create(@Valid @RequestBody Address entity) {
        Address savedEntity = addressRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@PathVariable String id, @Valid @RequestBody Address entity) {
        if (!addressRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Address updatedEntity = addressRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!addressRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        addressRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
