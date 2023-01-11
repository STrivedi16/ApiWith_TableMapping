package spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ListInterface.CustomerInterface;
import spring.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<CustomerInterface> findById(int id, Class<CustomerInterface> class1);

	@Query(value = "select ce.name , ce.number , de.address , ce.city, de.pincode from customer_entity as ce inner join detail as de on ce.address_addressid=de.addressid ", nativeQuery = true)
	List<CustomerInterface> findAll(Class<CustomerInterface> class1);

}
