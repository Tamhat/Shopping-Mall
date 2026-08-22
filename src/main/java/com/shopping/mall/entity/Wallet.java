package com.shopping.mall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "wallets")
public class Wallet {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "walletId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "walletId is required")
    private String walletId;
    @NotBlank(message = "customerId is required")
    @NotBlank(message = "customerId is required")
    private String customerId;
    private BigDecimal balance;
    @NotBlank(message = "currency is required")
    @NotBlank(message = "currency is required")
    private String currency;
    private LocalDateTime lastTransactionDate;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private WalletStatus status;

    public enum WalletStatus {
        ACTIVE,
        FROZEN
    }
}