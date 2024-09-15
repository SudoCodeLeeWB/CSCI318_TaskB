package Jome.Order_Microservice.infrastructure.persistence;

import Jome.Order_Microservice.domain.entity.Shipped;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippedRepository extends JpaRepository<Shipped , Long> {

}
