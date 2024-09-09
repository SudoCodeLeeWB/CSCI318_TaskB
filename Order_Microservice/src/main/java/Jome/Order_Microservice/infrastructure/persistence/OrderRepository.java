package Jome.Order_Microservice.infrastructure.persistence;

import Jome.Order_Microservice.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // TODO : make the entity and pass it
public interface OrderRepository extends JpaRepository<Order, Long> {
}
