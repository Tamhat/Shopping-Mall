package com.shopping.mall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "productId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "productId is required")
    private String productId;
    @NotBlank(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;
    private String description;
    @PositiveOrZero(message = "price must be positive or zero")
    private BigDecimal price;
    @NotBlank(message = "sku is required")
    @NotBlank(message = "sku is required")
    private String sku;
    @NotBlank(message = "categoryId is required")
    @NotBlank(message = "categoryId is required")
    private String categoryId;
    @NotBlank(message = "storeId is required")
    @NotBlank(message = "storeId is required")
    private String storeId;
    private List<String> images;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    public enum ProductStatus {
        DRAFT,
        PUBLISHED,
        OUT_OF_STOCK,
        DISCONTINUED
    }
}