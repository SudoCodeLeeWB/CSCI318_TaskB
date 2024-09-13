package Jome.Order_Microservice.presentation;

import Jome.Order_Microservice.applicaion.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController( OrderService orderService){
        this.orderService = orderService;
    }


    // Use Case 1 : Add A new product to the order



    // Use Case 2 : View Past orders of a user



    // Use Case 3 :  Place Order





}
