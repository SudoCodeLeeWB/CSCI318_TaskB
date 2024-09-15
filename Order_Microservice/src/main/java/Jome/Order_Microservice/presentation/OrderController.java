package Jome.Order_Microservice.presentation;

import Jome.Order_Microservice.applicaion.OrderService;
import Jome.Order_Microservice.dto.CustomerOrderDTO;
import Jome.Order_Microservice.dto.ShippedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController( OrderService orderService){
        this.orderService = orderService;
    }


    @PostMapping("/hello")
    public ResponseEntity<String>hello() {
        return ResponseEntity.ok("Hello");
    }


    // Use Case 1: Add new product
    @PostMapping("/add/{customerId}/{productId}/{quantity}")
    public ResponseEntity<CustomerOrderDTO> addProductToOrder(
            @PathVariable Long customerId,
            @PathVariable Long productId,
            @PathVariable int quantity) {

        CustomerOrderDTO customerOrderDTO = orderService.addNewProductToOrder(customerId, productId, quantity);
        if (customerOrderDTO != null) {
            return ResponseEntity.ok(customerOrderDTO);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Use Case 2: place order
    @PostMapping("/place/{orderId}")
    public ResponseEntity<ShippedDTO> placeOrder(@PathVariable Long orderId) {
        ShippedDTO shippedOrderDTO = orderService.placeOrder(orderId);
        if (shippedOrderDTO != null) {
            return ResponseEntity.ok(shippedOrderDTO);
        } else {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Use Case 3: Mark the order as delivered
    @PostMapping("/deliver/{shippedId}")
    public ResponseEntity<ShippedDTO> markOrderAsDelivered(@PathVariable Long shippedId) {
        ShippedDTO deliveredOrderDTO = orderService.deliveryFinish(shippedId);
        if (deliveredOrderDTO != null) {
            return ResponseEntity.ok(deliveredOrderDTO);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
