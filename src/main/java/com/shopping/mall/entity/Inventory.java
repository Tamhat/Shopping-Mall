package com.shopping.mall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "inventorys")
public class Inventory {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "inventoryId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "inventoryId is required")
    private String inventoryId;
    @NotBlank(message = "productId is required")
    @NotBlank(message = "productId is required")
    private String productId;
    private int quantityAvailable;
    private int quantityReserved;
    @NotBlank(message = "warehouseLocation is required")
    @NotBlank(message = "warehouseLocation is required")
    private String warehouseLocation;
    private LocalDateTime lastUpdated;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private InventoryStatus status;

    public enum InventoryStatus {
        IN_STOCK,
        LOW_STOCK,
        OUT_OF_STOCK
    }
}