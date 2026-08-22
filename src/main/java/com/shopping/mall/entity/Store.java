package com.shopping.mall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "stores")
public class Store {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "storeId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "storeId is required")
    private String storeId;
    @NotBlank(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "ownerId is required")
    @NotBlank(message = "ownerId is required")
    private String ownerId;
    @NotBlank(message = "categoryId is required")
    @NotBlank(message = "categoryId is required")
    private String categoryId;
    @NotBlank(message = "location is required")
    @NotBlank(message = "location is required")
    private String location;
    private double rating;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private StoreStatus status;

    public enum StoreStatus {
        PENDING_APPROVAL,
        ACTIVE,
        SUSPENDED,
        CLOSED
    }
}