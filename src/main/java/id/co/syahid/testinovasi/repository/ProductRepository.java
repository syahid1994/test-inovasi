package id.co.syahid.testinovasi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.syahid.testinovasi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByProductID(String productID);
}
