package Jome.Order_Microservice.infrastructure.persistence;

import Jome.Order_Microservice.domain.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository  // TODO : make the entity and pass it
public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
    Optional<CustomerOrder> findFirstByCustomerIDAndPaidFalse(Long customerId);

}
