package com.shopping.mall.entity;

import java.time.LocalDate;
import java.util.List;

public class Promotion {

    private String promoId;
    private String name;
    private DiscountType discountType;
    private double discountValue;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> applicableProducts;
    private PromotionStatus status;

    public enum DiscountType {
        PERCENTAGE,
        FLAT_AMOUNT
    }

    public enum PromotionStatus {
        DRAFT,
        SCHEDULED,
        ACTIVE,
        EXPIRED
    }
}
