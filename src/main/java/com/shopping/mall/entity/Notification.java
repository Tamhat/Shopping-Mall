package com.shopping.mall.entity;

import java.time.LocalDateTime;

public class Notification {

    private String notificationId;
    private String recipientId;
    private String type;
    private String message;
    private LocalDateTime sentDate;
    private NotificationStatus readStatus;
    private String referenceId; // orderId / promoId / ticketId (nullable)

    public enum NotificationStatus {
        UNREAD,
        READ
    }
}
