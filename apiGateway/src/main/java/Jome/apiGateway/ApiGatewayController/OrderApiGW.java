package Jome.apiGateway.ApiGatewayController;


import Jome.apiGateway.ApiGatewayController.ApiGatewayHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/orders")
public class OrderApiGW {

    private final RestTemplate restTemplate;

    @Value("order.service.url")
    private String orderMicroServiceUrl;

    @Autowired
    public OrderApiGW( RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



//    // Use Case 1 : Add the new product to the order
//    @PostMapping("/create")
//    public ResponseEntity<Object> addProduct(){}
//
//
//    // Use Case 2 : View Past orders
//    @PatchMapping("/patch")
//    public ResponseEntity<Object> updateProduct(){}
//
//
//    // Use Case 3 : Place Order
//    @GetMapping("/search")
//    public ResponseEntity<Object> searchProduct(){}
//




}
