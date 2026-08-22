package com.shopping.mall.entity;

public class Category {

    private String categoryId;
    private String name;
    private String parentCategoryId; // nullable — self-referencing
    private String icon;
}
