package Jome.Product_Microservice.applicaion;

import Jome.Product_Microservice.infrastructure.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    // product repository if needed.
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    /*
    * TODO :
    * 1. implement the actual business logic here ( divide the usecase into smaller tasks )
    *  => the method is a usecase and the inner logic is a subdivided tasks for the usecase.
    * 2. include required methods & repositories
    *   Ex) api call for other microservice --> call other microservice | call the repository ( done )
    *
    * */


    public String isDataFlowWorking(Long id){

        // in this place the Use case should be implemented
        String ProductServiceString = String.format("Hello from Product Micro Service, passed id : %d ", id);

        return ProductServiceString;

    }

}
