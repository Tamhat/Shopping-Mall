import java.util.List;
import java.util.Optional;

public interface AddressRepository {
    Address save(Address entity);
    Optional<Address> findById(String id);
    List<Address> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
