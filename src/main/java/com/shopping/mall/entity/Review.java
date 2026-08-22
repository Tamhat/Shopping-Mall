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
@Table(name = "reviews")
public class Review {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "reviewId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "reviewId is required")
    private String reviewId;
    @NotBlank(message = "productId is required")
    @NotBlank(message = "productId is required")
    private String productId;
    @NotBlank(message = "customerId is required")
    @NotBlank(message = "customerId is required")
    private String customerId;
    private String comment;
    private int rating;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private ReviewStatus status;

    public enum ReviewStatus {
        PENDING,
        PUBLISHED,
        REMOVED
    }
}