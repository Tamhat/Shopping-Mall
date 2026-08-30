package com.shopping.mall.service.catalog;

public class ProductService {

    public void addProduct() {}
    // RBAC: StoreOwner

    public void editProduct() {}
    // RBAC: StoreOwner

    public void deleteProduct() {}
    // RBAC: StoreOwner

    public void viewProduct() {}
    // RBAC: Customer, Guest

    public void addToCart() {}
    // RBAC: Customer

    public void addToWishlist() {}
    // RBAC: Customer
}
