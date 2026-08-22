import java.time.LocalDate;

public class Mall {

    private String mallId;
    private String name;
    private String address;
    private String openingHours;
    private int totalStores;
    private LocalDate establishedDate;
    private MallStatus status;

    public enum MallStatus {
        ACTIVE,
        UNDER_RENOVATION,
        CLOSED
    }
}