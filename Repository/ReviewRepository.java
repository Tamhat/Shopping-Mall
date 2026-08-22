import java.util.List;
import java.util.Optional;

public interface ReviewRepository {
    Review save(Review entity);
    Optional<Review> findById(String id);
    List<Review> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
