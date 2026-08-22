package com.shopping.mall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "addresss")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String addressId;
    @NotBlank(message = "customerId is required")
    @NotBlank(message = "customerId is required")
    private String customerId;
    @NotBlank(message = "label is required")
    @NotBlank(message = "label is required")
    private String label;
    @NotBlank(message = "street is required")
    @NotBlank(message = "street is required")
    private String street;
    @NotBlank(message = "city is required")
    @NotBlank(message = "city is required")
    private String city;
    @NotBlank(message = "postalCode is required")
    @NotBlank(message = "postalCode is required")
    private String postalCode;
    private boolean isDefault;
}