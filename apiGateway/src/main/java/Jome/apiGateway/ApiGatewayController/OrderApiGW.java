package Jome.apiGateway.ApiGatewayController;
import Jome.apiGateway.dto.CustomerOrderDTO;
import Jome.apiGateway.dto.ShippedDTO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
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

    @Value("${order.service.url}")
    private String orderMicroServiceUrl;

    @Autowired
    public OrderApiGW( RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Use Case 1: Add new product
    @PostMapping("/add/{customerId}/{productId}/{quantity}")
    public ResponseEntity<CustomerOrderDTO> addProduct(@PathVariable long customerId, @PathVariable long productId, @PathVariable long quantity){
        String microServiceMapping = "/add/"+customerId+"/"+productId+"/"+quantity;
        return ApiGatewayHelper.forwardRequest(restTemplate, orderMicroServiceUrl, microServiceMapping, HttpMethod.POST, CustomerOrderDTO.class);
    }

    // Use Case 2: place order
    @PostMapping("/place/{orderId}")
    public ResponseEntity<ShippedDTO> updateProduct(@PathVariable long orderId){
        String microServiceMapping = "/place/"+orderId;
        return ApiGatewayHelper.forwardRequest(restTemplate, orderMicroServiceUrl, microServiceMapping, HttpMethod.POST, ShippedDTO.class);
    }


   // Use Case 3: Mark the order as delivered
    @PostMapping("/deliver/{shippedId}")
    public ResponseEntity<ShippedDTO> searchProduct(@PathVariable long shippedId){
        String microServiceMapping = "/deliver/"+shippedId;
        return ApiGatewayHelper.forwardRequest(restTemplate, orderMicroServiceUrl, microServiceMapping, HttpMethod.POST, ShippedDTO.class);
    }

 



}
