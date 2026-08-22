package com.shopping.mall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ratings")
public class Rating {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "ratingId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "ratingId is required")
    private String ratingId;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private TargetType targetType;
    @NotBlank(message = "targetId is required")
    @NotBlank(message = "targetId is required")
    private String targetId;
    @NotBlank(message = "customerId is required")
    @NotBlank(message = "customerId is required")
    private String customerId;
    private int score;

    public enum TargetType {
        PRODUCT,
        STORE
    }
}