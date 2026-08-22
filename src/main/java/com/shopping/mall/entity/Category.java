package com.shopping.mall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categorys")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "categoryId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "categoryId is required")
    private String categoryId;
    @NotBlank(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "parentCategoryId is required")
    @NotBlank(message = "parentCategoryId is required")
    private String parentCategoryId;
    @NotBlank(message = "icon is required")
    @NotBlank(message = "icon is required")
    private String icon;
}