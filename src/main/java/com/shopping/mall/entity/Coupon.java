package com.shopping.mall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "coupons")
public class Coupon {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "couponId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "couponId is required")
    private String couponId;
    @NotBlank(message = "code is required")
    @NotBlank(message = "code is required")
    private String code;
    @NotBlank(message = "promoId is required")
    @NotBlank(message = "promoId is required")
    private String promoId;
    private double discountValue;
    private int usageLimit;
    private LocalDate expiryDate;
    private int usedCount;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private CouponStatus status;

    public enum CouponStatus {
        ACTIVE,
        EXPIRED,
        EXHAUSTED
    }
}