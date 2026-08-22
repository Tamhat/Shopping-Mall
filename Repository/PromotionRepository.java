import java.util.List;
import java.util.Optional;

public interface PromotionRepository {
    Promotion save(Promotion entity);
    Optional<Promotion> findById(String id);
    List<Promotion> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
