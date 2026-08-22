import java.math.BigDecimal;
import java.util.List;

public class Product {

    private String productId;
    private String name;
    private String description;
    private BigDecimal price;
    private String sku;
    private String categoryId;
    private String storeId;
    private List<String> images;
    private ProductStatus status;

    public enum ProductStatus {
        DRAFT,
        PUBLISHED,
        OUT_OF_STOCK,
        DISCONTINUED
    }
}
