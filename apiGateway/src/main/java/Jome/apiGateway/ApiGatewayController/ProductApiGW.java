package Jome.apiGateway.ApiGatewayController;

// to use the Api Gateway helper -> The static method
import Jome.apiGateway.ApiGatewayController.ApiGatewayHelper;
import Jome.apiGateway.dto.ProductDTO;
import Jome.apiGateway.dto.ProductStockDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import org.springframework.core.ParameterizedTypeReference;
import java.util.List;




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


    // The string will become some_DTO object later => needs to be modified? TODO
    @GetMapping("/getProduct/{productId}")
    public ResponseEntity<String> getProductById(@PathVariable Long productId) {
        String microServiceMapping = "/get/" + productId;
        return ApiGatewayHelper.forwardRequest(restTemplate, productMicroServiceUrl, microServiceMapping, HttpMethod.GET, String.class);
    }


    // currently it just returns the result from application layer from each microservice.

   // Use Case 1 : Add new product
    @PostMapping("/create")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO body) {
        String microServiceMapping = "/create";
        return ApiGatewayHelper.forwardRequest(restTemplate, productMicroServiceUrl, microServiceMapping, HttpMethod.POST, body, ProductDTO.class);
    }

    // Use Case 2 : Update Product Stock
    @PostMapping("/patch/{productId}")
    public ResponseEntity<ProductStockDTO> updateProduct(@PathVariable Long productId, @RequestBody int body) {
        // take id -> replace object in its place
        String microServiceMapping = "/patch/" + productId;
        return ApiGatewayHelper.forwardRequest(restTemplate, productMicroServiceUrl, microServiceMapping, HttpMethod.POST, body, ProductStockDTO.class);
    }

    // Use Case 3 : View Preferred Category product
    @GetMapping("/get/prefer/{productId}")
    public ResponseEntity<List<ProductDTO>> searchProduct(@PathVariable Long productId) {
        String microServiceMapping = "/get/prefer/" + productId;
        ResponseEntity<List<ProductDTO>> response = restTemplate.exchange(
            productMicroServiceUrl + microServiceMapping,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<ProductDTO>>() {}
        );
        return ResponseEntity.ok(response.getBody());

    }

    // Use Case 4 : Get Items which quantity is more than 1
    @GetMapping("/get/available")
    public ResponseEntity<List<ProductStockDTO>> preferredProduct() {
        String microServiceMapping = "/get/available";
        ResponseEntity<List<ProductStockDTO>> response = restTemplate.exchange(
            productMicroServiceUrl + microServiceMapping,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<ProductStockDTO>>() {}
        );
        return ResponseEntity.ok(response.getBody());
    }


}