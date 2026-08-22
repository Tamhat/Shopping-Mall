package com.shopping.mall.service;

public class StoreService {

    public void createStore() {}
    // RBAC: StoreOwner

    public void updateStore() {}
    // RBAC: StoreOwner

    public void addProduct() {}
    // RBAC: StoreOwner

    public void approveStore() {}
    // RBAC: MallAdmin

    public void suspendStore() {}
    // RBAC: MallAdmin
}
