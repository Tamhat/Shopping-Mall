import java.util.List;
import java.util.Optional;

public interface WalletRepository {
    Wallet save(Wallet entity);
    Optional<Wallet> findById(String id);
    List<Wallet> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
