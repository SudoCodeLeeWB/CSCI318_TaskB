package Jome.Order_Microservice.applicaion;


import Jome.Order_Microservice.infrastructure.persistence.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    // Use Case 1 : Add A new product to the order



    // Use Case 2 : View Past orders of a user



    // Use Case 3 :  Place Order





}
