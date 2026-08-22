package com.shopping.mall.entity;

public class Complaint {

    private String ticketId;
    private String customerId;
    private String orderId; // nullable
    private String subject;
    private String description;
    private String priority;
    private ComplaintStatus status;

    public enum ComplaintStatus {
        OPEN,
        IN_PROGRESS,
        RESOLVED,
        CLOSED
    }
}