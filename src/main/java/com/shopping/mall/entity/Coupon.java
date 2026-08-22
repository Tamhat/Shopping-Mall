package com.shopping.mall.entity;

import java.time.LocalDate;

public class Coupon {

    private String couponId;
    private String code;
    private String promoId;
    private double discountValue;
    private int usageLimit;
    private LocalDate expiryDate;
    private int usedCount;
    private CouponStatus status;

    public enum CouponStatus {
        ACTIVE,
        EXPIRED,
        EXHAUSTED
    }
}
