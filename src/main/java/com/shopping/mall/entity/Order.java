package com.shopping.mall.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private String orderId;
    private String customerId;
    private String storeId;
    private List<String> items; // productId + quantity entries
    private BigDecimal totalAmount;
    private LocalDateTime orderDate;
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
