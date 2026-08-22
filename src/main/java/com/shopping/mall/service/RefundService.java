package com.shopping.mall.service;

public class RefundService {

    public void requestRefund() {}
    // RBAC: Customer

    public void approveRefund() {}
    // RBAC: SupportAgent

    public void rejectRefund() {}
    // RBAC: SupportAgent

    public void processRefund() {}
    // RBAC: Finance
}
