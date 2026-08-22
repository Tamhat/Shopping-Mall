import java.util.List;
import java.util.Optional;

public interface DeliveryRepository {
    Delivery save(Delivery entity);
    Optional<Delivery> findById(String id);
    List<Delivery> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
