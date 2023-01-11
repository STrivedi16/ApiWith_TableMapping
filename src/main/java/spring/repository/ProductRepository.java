package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	// List<ProductInterface> findAllitem(Class<ProductInterface> class1);
}
