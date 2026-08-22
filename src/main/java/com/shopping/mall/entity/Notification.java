package com.shopping.mall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "notifications")
public class Notification {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "notificationId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "notificationId is required")
    private String notificationId;
    @NotBlank(message = "recipientId is required")
    @NotBlank(message = "recipientId is required")
    private String recipientId;
    @NotBlank(message = "type is required")
    @NotBlank(message = "type is required")
    private String type;
    @NotBlank(message = "message is required")
    @NotBlank(message = "message is required")
    private String message;
    private LocalDateTime sentDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private NotificationStatus readStatus;
    @NotBlank(message = "referenceId is required")
    @NotBlank(message = "referenceId is required")
    private String referenceId;

    public enum NotificationStatus {
        UNREAD,
        READ
    }
}