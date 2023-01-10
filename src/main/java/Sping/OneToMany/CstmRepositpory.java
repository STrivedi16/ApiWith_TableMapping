package Sping.OneToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.entity.CustomerOM;

@Repository
public interface CstmRepositpory extends JpaRepository<CustomerOM, Integer> {

}
