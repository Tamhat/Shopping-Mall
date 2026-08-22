import java.time.LocalDate;

public class Review {

    private String reviewId;
    private String productId;
    private String customerId;
    private String comment;
    private int rating; // 1-5
    private LocalDate date;
    private ReviewStatus status;

    public enum ReviewStatus {
        PENDING,
        PUBLISHED,
        REMOVED
    }
}
