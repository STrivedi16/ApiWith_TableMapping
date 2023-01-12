package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByProductid(Integer item_productid);

	// List<ProductInterface> findAll(Class<ProductInterface> class1);

	// Optional<Customer> findByProductid(Product item_productid);

	// List<ProductInterface> findAllitem(Class<ProductInterface> class1);

	// List<ProductInterface> findAll(Class<ProductInterface> class1, Integer
	// pagenumber, Integer pagesize);
}
