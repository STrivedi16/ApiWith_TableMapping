package spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ListInterface.CustomerProductInterface;
import spring.entity.Customer;
import spring.entity.CustumerProductEntity;

@Repository
public interface customer_entity_itemReposiory extends JpaRepository<CustumerProductEntity, Integer> {

	CustumerProductEntity save(Customer customer);

	@Query(value = "select cpm.customer_id_id As CustomerId , cpm.item_productid_productid  as ItemIroductId from custumer_product_mapping cpm", nativeQuery = true)
	List<CustomerProductInterface> findAll(Class<CustomerProductInterface> class2);

}
