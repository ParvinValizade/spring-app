package paputu.company.az.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import paputu.company.az.model.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findProductByProductHashCode(String productHashCode);

    void deleteProductByProductHashCode(String productHashCode);
}
