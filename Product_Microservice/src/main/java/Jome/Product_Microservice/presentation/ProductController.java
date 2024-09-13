package Jome.Product_Microservice.presentation;

import Jome.Product_Microservice.applicaion.ProductService;
import Jome.Product_Microservice.domain.entity.Product;
import Jome.Product_Microservice.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }


    /*
    * TODO:
    *  add REST mappings for the usecase api calls
    * Implment DTO layer
    * Restcontroller => Service
    *
    * */


    // implement the try catch for here
    @GetMapping("/get/{productId}")
    public ResponseEntity<String> connectionString(@PathVariable Long productId){

        String result = productService.isDataFlowWorking(productId);
        return ResponseEntity.ok(result);
    }

    // TODO : Implement the each use cases
    // Required steps :
    // Step 1 : implement the Use case in the Service
    // Step 2 : Define the use case's return value
    // Step 3 : Fix the Return generics of a ResponseEntity


    // Use Case 1 : Add the product
    @PostMapping("/create")
    public ResponseEntity<ProductDTO> addNewProduct(@RequestBody Product product){
        try {
            ProductDTO result = productService.addNewProduct(product);
            return ResponseEntity.ok(result);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



//
//    // Use Case 2 : Update Product Stock
//    // Send the product name and new quantity using
//    @PatchMapping("/patch/{product_name}/{quantity}")
//    public ResponseEntity<Object> updateProduct(@PathVariable String product_name , @PathVariable int quantity){
//
//        try{
//            ProductDTO updateResult = productService.updateProductStock( product_name , quantity);
//        }
//
//    }



//
//    // Use Case 3 : Search Products with string
//    @GetMapping("/search")
//    public ResponseEntity<Object> searchProduct(){}
//
//
//    // Use Case 4 : View 10 Preferred Category product
//    @GetMapping("/prefer")
//    public ResponseEntity<Object> preferredProduct(){}
//

}
