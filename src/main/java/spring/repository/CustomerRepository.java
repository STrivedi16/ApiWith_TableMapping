package spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ListInterface.BuyInterface;
import ListInterface.CustomerId;
import ListInterface.CustomerInterface;
import spring.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<CustomerId> findById(int id, Class<CustomerId> class1);

	@Query(value = "select ce.name , ce.number , de.address , ce.city, de.pincode from customer_entity as ce inner join detail as de on ce.address_addressid=de.addressid ", nativeQuery = true)
	List<CustomerInterface> findAll(Class<CustomerInterface> class1);

	BuyInterface save(BuyInterface cstmprod);

	Optional<Customer> findById(Customer customer_id);

	@Query(value = "select ce.name , ce.number , de.address , ce.city, de.pincode from customer_entity as ce inner join detail as de on ce.address_addressid=de.addressid where de.is_active=true ", nativeQuery = true)
	Page<CustomerInterface> findAll(Pageable pageable, Class<CustomerInterface> class1);

	@Query(value = "select * from customer_entity where email= :customer", nativeQuery = true)
	Customer findByEmail(@Param("customer") String username);

//	@Query(value = "select * from customer_entity where email= :customer", nativeQuery = true)
//	Customer findByEmail(@Param("customer") String customer);

}
