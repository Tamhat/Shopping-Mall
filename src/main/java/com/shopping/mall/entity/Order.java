package com.shopping.mall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "orderId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "orderId is required")
    private String orderId;
    @NotBlank(message = "customerId is required")
    @NotBlank(message = "customerId is required")
    private String customerId;
    @NotBlank(message = "storeId is required")
    @NotBlank(message = "storeId is required")
    private String storeId;
    private List<String> items;
    @PositiveOrZero(message = "totalAmount must be positive or zero")
    private BigDecimal totalAmount;
    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public enum OrderStatus {
        PLACED,
        CONFIRMED,
        PREPARING,
        SHIPPED,
        DELIVERED,
        CANCELLED,
        RETURNED
    }
}