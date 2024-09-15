package Jome.Product_Microservice.presentation;

import Jome.Product_Microservice.applicaion.ProductService;
import Jome.Product_Microservice.dto.ProductDTO;
import Jome.Product_Microservice.dto.ProductStockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    /*
     Rest Controller => Service
     Required steps : refer to the First use case
     Step 1 : implement the Use case in the Service
     Step 2 : Define the use case's return value
     Step 3 : Fix the Return generics of a ResponseEntity
     */


    // implement the try catch for here
    @GetMapping("/get/{productId}")
    public ResponseEntity<String> connectionString(@PathVariable Long productId){

        String result = productService.isDataFlowWorking(productId);
        return ResponseEntity.ok(result);
    }


    // Use Case 1 : Add the product
    @PostMapping("/create")
    public ResponseEntity<ProductDTO> addNewProduct(@RequestBody ProductDTO product){
        try {
            ProductDTO result = productService.addNewProduct(product);
            return ResponseEntity.ok(result);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Use Case 2 : Update Product Stock
    // Send the product name and new quantity using
    @PatchMapping("/patch/{productId}/{quantity}")
    public ResponseEntity<ProductStockDTO> updateProductStock(@PathVariable Long productId, @PathVariable int quantity){
        try{
            ProductStockDTO updateResult = productService.updateProductStock( productId , quantity);
            return ResponseEntity.ok(updateResult);
        }
        catch(Exception e){
            System.out.println("prod controller exception");

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Use Case 3 : View Preferred Category product
    @GetMapping("/get/prefer/{customer_id}")
    public ResponseEntity<List<ProductDTO>> getPreferenceProduct(@PathVariable Long customer_id){

        try{
            List<ProductDTO> preferProducts = productService.getPreferredItems(customer_id);
            return ResponseEntity.ok(preferProducts);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Use Case 4 : Get Items which quantity is more than 1
    @GetMapping("/get/available")
    public ResponseEntity<List<ProductStockDTO>> preferredProduct(){

        try{
            List<ProductStockDTO> availableProducts = productService.getAvailableItems();
            return ResponseEntity.ok(availableProducts);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    // Other Calls that needs to be used for Complex Usecases  : TODO





}
