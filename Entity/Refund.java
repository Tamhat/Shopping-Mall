import java.math.BigDecimal;
import java.time.LocalDate;

public class Refund {

    private String refundId;
    private String orderId;
    private String reason;
    private BigDecimal amount;
    private LocalDate requestDate;
    private RefundStatus status;

    public enum RefundStatus {
        REQUESTED,
        APPROVED,
        REJECTED,
        PROCESSED
    }
}
