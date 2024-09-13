package Jome.Product_Microservice.applicaion;

import Jome.Product_Microservice.domain.entity.Product;
import Jome.Product_Microservice.dto.ProductDTO;
import Jome.Product_Microservice.infrastructure.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    // Use Case 1 : Add new Product => return the saved product DTO as a result
    public ProductDTO addNewProduct(Product newProduct ){

        Product savedClass = productRepository.save(newProduct);
        return ProductDTO.convertToDTO(savedClass);

    }


//    // Use case 2 : Update the Product Stock
//   public ProductDTO updateProductStock(String productName , int quantity ){
//
//        // Step 1 : Reterive the original data from product Repository
//        // Step 2 : modify the aggregate
//        // Step 3 : Save the converted Aggregate
//        return ProductDTO.convertToDTO_quantity()
//   }


//    // Use Case 3 : View items from 10 preferred category
//    // get the user id
//    public List<ProductDTO> getPreferredItems( Long id ){
//
//        // step 1 : get the prefered category from the user ( the user's catgory is from id of a user )
//
//        // step 2 : get the 10 items (or less) , which has same category, from the database
//
//        // step 3 : make these items as a DTO , and return the list of it
//    }



//    // Use case 4 : Get items which quantity is more than 1
//    // no inputs , just output
//    public List<ProductDTO> getAvailableItems(){
//
//        // step 1 : get the items which quantity is more than 1
//        // step 2 : make these as a DTO, and return the list of it.
//
//    }
//




}
