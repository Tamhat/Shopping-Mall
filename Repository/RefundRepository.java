import java.util.List;
import java.util.Optional;

public interface RefundRepository {
    Refund save(Refund entity);
    Optional<Refund> findById(String id);
    List<Refund> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
