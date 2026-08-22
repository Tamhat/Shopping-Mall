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
@Table(name = "malls")
public class Mall {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "mallId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "mallId is required")
    private String mallId;
    @NotBlank(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;
    private String address;
    @NotBlank(message = "openingHours is required")
    @NotBlank(message = "openingHours is required")
    private String openingHours;
    private int totalStores;
    private LocalDate establishedDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private MallStatus status;

    public enum MallStatus {
        ACTIVE,
        UNDER_RENOVATION,
        CLOSED
    }
}