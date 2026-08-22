package com.shopping.mall.entity;

import java.time.LocalDateTime;

public class Inventory {

    private String inventoryId;
    private String productId;
    private int quantityAvailable;
    private int quantityReserved;
    private String warehouseLocation;
    private LocalDateTime lastUpdated;
    private InventoryStatus status;

    public enum InventoryStatus {
        IN_STOCK,
        LOW_STOCK,
        OUT_OF_STOCK
    }
}
