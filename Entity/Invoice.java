import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Invoice {

    private String invoiceId;
    private String orderId;
    private LocalDate issueDate;
    private List<String> items; // line items
    private BigDecimal totalAmount;
    private BigDecimal taxAmount;
}
