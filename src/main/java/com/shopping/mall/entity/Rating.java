package com.shopping.mall.entity;

public class Rating {

    private String ratingId;
    private TargetType targetType; // Product or Store
    private String targetId;
    private String customerId;
    private int score; // 1-5

    public enum TargetType {
        PRODUCT,
        STORE
    }
}
