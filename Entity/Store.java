public class Store {

    private String storeId;
    private String name;
    private String ownerId;
    private String categoryId;
    private String location; // floor/unit
    private double rating;
    private StoreStatus status;

    public enum StoreStatus {
        PENDING_APPROVAL,
        ACTIVE,
        SUSPENDED,
        CLOSED
    }
}
