package com.shopping.mall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "deliverys")
public class Delivery {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "deliveryId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "deliveryId is required")
    private String deliveryId;
    @NotBlank(message = "orderId is required")
    @NotBlank(message = "orderId is required")
    private String orderId;
    private String address;
    @NotBlank(message = "courier is required")
    @NotBlank(message = "courier is required")
    private String courier;
    @NotBlank(message = "trackingNumber is required")
    @NotBlank(message = "trackingNumber is required")
    private String trackingNumber;
    private LocalDate estimatedDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public enum DeliveryStatus {
        PENDING,
        PICKED_UP,
        IN_TRANSIT,
        DELIVERED,
        FAILED
    }
}