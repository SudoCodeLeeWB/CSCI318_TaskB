package Jome.Product_Microservice.presentation;

import Jome.Product_Microservice.applicaion.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }


//    private final
    /*
    * TODO:
    *  add REST mappings for the usecase api calls
    * Implment DTO layer
    * Implement Try-Catch here : Restcontroller => Service
    * */


    // implement the try catch for here
    @GetMapping("/getProduct/{productId}")
    public ResponseEntity<String> connectionString(@PathVariable Long productId){

        String result = productService.isDataFlowWorking(productId);
        return ResponseEntity.ok(result);
    }





}
