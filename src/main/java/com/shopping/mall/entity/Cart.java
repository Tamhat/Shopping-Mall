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
@Table(name = "carts")
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "cartId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "cartId is required")
    private String cartId;
    @NotBlank(message = "customerId is required")
    @NotBlank(message = "customerId is required")
    private String customerId;
    private List<String> items;
    @PositiveOrZero(message = "totalPrice must be positive or zero")
    private BigDecimal totalPrice;
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private CartStatus status;

    public enum CartStatus {
        ACTIVE,
        CHECKED_OUT,
        ABANDONED
    }
}