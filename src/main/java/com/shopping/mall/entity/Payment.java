package com.shopping.mall.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {

    private String paymentId;
    private String orderId;
    private BigDecimal amount;
    private String method;
    private PaymentStatus status;
    private LocalDateTime transactionDate;

    public enum PaymentStatus {
        PENDING,
        SUCCESS,
        FAILED,
        REFUNDED
    }
}
