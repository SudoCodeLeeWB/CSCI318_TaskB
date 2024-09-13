package Jome.Product_Microservice.infrastructure.persistence;

import Jome.Product_Microservice.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


// Note : Jpa repository must have 2 different Generic parameters : Type and primary key
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // add additional if needed

    // To get a list of products using category :
    List<Product> findByCategory(String category);

    // To get a List of Products where the stock is more than 1
    List<Product> findByStockGreaterThan (int stock);

}
