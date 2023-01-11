package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.entity.Customer;
import spring.entity.customer_entity_item;

public interface customer_entity_itemReposiory extends JpaRepository<customer_entity_item, Integer> {

	customer_entity_item save(Customer customer);

}
