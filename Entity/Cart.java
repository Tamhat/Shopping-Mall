import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Cart {

    private String cartId;
    private String customerId;
    private List<String> items; // productId + quantity entries
    private BigDecimal totalPrice;
    private LocalDateTime updatedAt;
    private CartStatus status;

    public enum CartStatus {
        ACTIVE,
        CHECKED_OUT,
        ABANDONED
    }
}
