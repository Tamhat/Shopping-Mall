package com.shopping.mall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "promotions")
public class Promotion {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "promoId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "promoId is required")
    private String promoId;
    @NotBlank(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private DiscountType discountType;
    private double discountValue;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> applicableProducts;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
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