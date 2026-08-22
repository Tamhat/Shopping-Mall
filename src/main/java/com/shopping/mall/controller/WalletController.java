package com.shopping.mall.controller;

import com.shopping.mall.entity.Wallet;
import com.shopping.mall.repository.WalletRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final WalletRepository walletRepository;

    @GetMapping
    public ResponseEntity<List<Wallet>> getAll() {
        return ResponseEntity.ok(walletRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wallet> getById(@PathVariable String id) {
        return walletRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Wallet> create(@Valid @RequestBody Wallet entity) {
        Wallet savedEntity = walletRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wallet> update(@PathVariable String id, @Valid @RequestBody Wallet entity) {
        if (!walletRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Wallet updatedEntity = walletRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!walletRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        walletRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
