package Jome.Product_Microservice.presentation;

import Jome.Product_Microservice.applicaion.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    *
    * */


    // for connection testing
    @GetMapping("/get")
    public String connectionString(){

        String result = productService.isDataFlowWorking();

        return result ;

    }



}
