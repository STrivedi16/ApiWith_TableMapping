package Sping.OneToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.entity.ProductOM;

@Repository
public interface ProdRepository extends JpaRepository<ProductOM, Integer> {

}
