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



}
