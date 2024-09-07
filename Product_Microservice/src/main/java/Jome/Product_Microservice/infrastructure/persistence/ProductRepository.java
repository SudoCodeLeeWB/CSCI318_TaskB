package Jome.Product_Microservice.infrastructure.persistence;

import Jome.Product_Microservice.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


// Note : Jpa repository must have 2 different Generic parameters : Type and primary key
public interface ProductRepository extends JpaRepository<Product, Long> {
    // add additional if needed
}
