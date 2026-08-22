package com.shopping.mall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "complaints")
public class Complaint {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "ticketId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "ticketId is required")
    private String ticketId;
    @NotBlank(message = "customerId is required")
    @NotBlank(message = "customerId is required")
    private String customerId;
    @NotBlank(message = "orderId is required")
    @NotBlank(message = "orderId is required")
    private String orderId;
    @NotBlank(message = "subject is required")
    @NotBlank(message = "subject is required")
    private String subject;
    private String description;
    @NotBlank(message = "priority is required")
    @NotBlank(message = "priority is required")
    private String priority;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private ComplaintStatus status;

    public enum ComplaintStatus {
        OPEN,
        IN_PROGRESS,
        RESOLVED,
        CLOSED
    }
}