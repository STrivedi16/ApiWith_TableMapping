package spring.repository;

import java.util.Comparator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByProductid(Integer item_productid);

	Product findByItem(Comparator<Product> comparator);

	Product findByItem(String product);

	Page<Product> findAll(Pageable pageable);

	// List<ProductInterface> findAll(Class<ProductInterface> class1);

	// Optional<Customer> findByProductid(Product item_productid);

	// List<ProductInterface> findAllitem(Class<ProductInterface> class1);

}
