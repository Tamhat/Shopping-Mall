import java.util.List;
import java.util.Optional;

public interface ComplaintRepository {
    Complaint save(Complaint entity);
    Optional<Complaint> findById(String id);
    List<Complaint> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
