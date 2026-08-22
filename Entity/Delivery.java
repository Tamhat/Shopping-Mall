import java.time.LocalDate;

public class Delivery {

    private String deliveryId;
    private String orderId;
    private String address;
    private String courier;
    private String trackingNumber;
    private LocalDate estimatedDate;
    private DeliveryStatus status;

    public enum DeliveryStatus {
        PENDING,
        PICKED_UP,
        IN_TRANSIT,
        DELIVERED,
        FAILED
    }
}
