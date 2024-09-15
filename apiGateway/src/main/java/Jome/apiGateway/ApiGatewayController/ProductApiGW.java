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
        System.out.println("Stub1");

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
   @PatchMapping("/patch/{productId}/{quantity}")
   public ResponseEntity<ProductStockDTO> updateProduct(@PathVariable Long productId, @PathVariable int quantity) {
    // take id -> replace object in its place
    String microServiceMapping = "/patch/" + productId + "/" + quantity;
    
    return ApiGatewayHelper.forwardRequest(restTemplate, productMicroServiceUrl, microServiceMapping, HttpMethod.PATCH, ProductStockDTO.class);

   }

//    // Use Case 3 : Search Products with string
//    @GetMapping("/search")
//    public ResponseEntity<String> searchProduct() {
//    }


//    // Use Case 4 : View 10 Preferred Category product
//    @GetMapping("/prefer")
//    public ResponseEntity<String> preferredProduct() {
//    }


}