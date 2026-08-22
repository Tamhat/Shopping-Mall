import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wallet {

    private String walletId;
    private String customerId;
    private BigDecimal balance;
    private String currency;
    private LocalDateTime lastTransactionDate;
    private WalletStatus status;

    public enum WalletStatus {
        ACTIVE,
        FROZEN
    }
}
