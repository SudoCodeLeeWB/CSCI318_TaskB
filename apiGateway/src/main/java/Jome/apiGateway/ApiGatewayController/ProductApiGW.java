package Jome.apiGateway.ApiGatewayController;

// to use the Api Gateway helper -> The static method
import Jome.apiGateway.ApiGatewayController.ApiGatewayHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


// Rest Controller for domain Product
@RestController
@RequestMapping("/api/products")
public class ProductApiGW {

    private final RestTemplate restTemplate;

    // Inject the microservice url from applicaion.properties
    @Value("${product.service.url}")
    private String productMicroServiceUrl;

    @Autowired
    public ProductApiGW(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    // The string will become some_DTO object later
    @GetMapping("/getProduct/{productId}")
    public ResponseEntity<String> getProductById(@PathVariable Long productId) {

        String microServiceMapping = "/get/" + productId;
        return ApiGatewayHelper.forwardRequest(restTemplate, productMicroServiceUrl, microServiceMapping, HttpMethod.GET, String.class);
    }


    // currently it just returns the result from application layer from each microservice.

//    // Use Case 1 : Add new product
//    @PostMapping("/create")
//    public ResponseEntity<String> addProduct() {
//    }
//
//    // Use Case 2 : Update Product Stock
//    @PatchMapping("/patch")
//    public ResponseEntity<String> updateProduct() {
//
//    }
//
//    // Use Case 3 : Search Products with string
//    @GetMapping("/search")
//    public ResponseEntity<String> searchProduct() {
//    }
//
//
//    // Use Case 4 : View 10 Preferred Category product
//    @GetMapping("/prefer")
//    public ResponseEntity<String> preferredProduct() {
//    }


}