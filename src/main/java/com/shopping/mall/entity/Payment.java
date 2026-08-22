package com.shopping.mall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payments")
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "paymentId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "paymentId is required")
    private String paymentId;
    @NotBlank(message = "orderId is required")
    @NotBlank(message = "orderId is required")
    private String orderId;
    @PositiveOrZero(message = "amount must be positive or zero")
    private BigDecimal amount;
    @NotBlank(message = "method is required")
    @NotBlank(message = "method is required")
    private String method;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    private LocalDateTime transactionDate;

    public enum PaymentStatus {
        PENDING,
        SUCCESS,
        FAILED,
        REFUNDED
    }
}