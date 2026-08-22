package com.shopping.mall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "refunds")
public class Refund {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "refundId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "refundId is required")
    private String refundId;
    @NotBlank(message = "orderId is required")
    @NotBlank(message = "orderId is required")
    private String orderId;
    @NotBlank(message = "reason is required")
    @NotBlank(message = "reason is required")
    private String reason;
    @PositiveOrZero(message = "amount must be positive or zero")
    private BigDecimal amount;
    private LocalDate requestDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private RefundStatus status;

    public enum RefundStatus {
        REQUESTED,
        APPROVED,
        REJECTED,
        PROCESSED
    }
}