package com.shopping.mall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "invoices")
public class Invoice {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "invoiceId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "invoiceId is required")
    private String invoiceId;
    @NotBlank(message = "orderId is required")
    @NotBlank(message = "orderId is required")
    private String orderId;
    private LocalDate issueDate;
    private List<String> items;
    @PositiveOrZero(message = "totalAmount must be positive or zero")
    private BigDecimal totalAmount;
    @PositiveOrZero(message = "taxAmount must be positive or zero")
    private BigDecimal taxAmount;
}