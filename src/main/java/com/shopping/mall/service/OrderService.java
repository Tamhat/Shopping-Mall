package com.shopping.mall.service;

public class OrderService {

    public void placeOrder() {}
    // RBAC: Customer

    public void cancelOrder() {}
    // RBAC: Customer

    public void confirmOrder() {}
    // RBAC: StoreOwner

    public void prepareOrder() {}
    // RBAC: StoreOwner, WarehouseStaff

    public void shipOrder() {}
    // RBAC: DeliveryStaff
}
