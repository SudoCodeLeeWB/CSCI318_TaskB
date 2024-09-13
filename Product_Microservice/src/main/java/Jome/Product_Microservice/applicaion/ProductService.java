package Jome.Product_Microservice.applicaion;

import Jome.Product_Microservice.domain.entity.Product;
import Jome.Product_Microservice.dto.ProductDTO;
import Jome.Product_Microservice.dto.ProductStockDTO;
import Jome.Product_Microservice.infrastructure.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    // only for debug & later usage
    public String isDataFlowWorking(Long id){

        // in this place the Use case should be implemented
        return String.format("Hello from Product Micro Service, passed id : %d ", id);
    }



    // Use Case 1 : Add new Product => return the saved product DTO as a result
    public ProductDTO addNewProduct(ProductDTO newProductDTO){  // consideration : we do not provide id normally,

        // 1. convert the product Dto into Product aggregate
        Product newProduct = Product.convertTOAggregate(newProductDTO);

        // 2. save() expects Aggregate | Save this new product into DataBase
        Product savedClass = productRepository.save(newProduct);

        // 3. Convert the saved Product into DTO , and return it.
        return ProductDTO.convertToDTO(savedClass);

    }


    // Use case 2 : Update the Product Stock
   public ProductStockDTO updateProductStock(Long productId, int quantity ){

        // Step 1 : Retrieve the original data from product Repository
        Product result =  productRepository.findById(productId)
                .map(
                        product -> {

                            // Step 2 : modify the aggregate
                            product.setStock(quantity);

                            // Step 3 : Save the modified Aggregate
                            return productRepository.save(product);
                        }).orElseThrow( () -> new RuntimeException("Product Not found with id " + productId));

        // Wrap with DTO & return the modified result
       return ProductStockDTO.convertToDTO(result);
   }



//    // Use Case 3 : View items from 10 preferred category => TODO // complex usecase
//    // get the user id
    public List<ProductDTO> getPreferredItems(Long id){

        // step 1 : get the prefered category from the user ( the user's catgory is from id of a user )
        // TODO ==> placeholder
        String category =  "Electronics"; // ( some outbound calls to the other microservice )

        // step 2 : get the items  which has same category, from the database
        List<Product> products = productRepository.findByCategory(category);

        // step 3 : make these items as a DTO , and return the list of it
        List<ProductDTO> preferProductDTOList = new ArrayList<>();
        for(Product product : products){
            preferProductDTOList.add(ProductDTO.convertToDTO(product));
        }
        return preferProductDTOList;
    }


    // Use case 4 : Get items which quantity is more than 1
    public List<ProductStockDTO> getAvailableItems(){

        // step 1 : get the items which quantity is more than 1
        List<Product> availableItems = productRepository.findByStockGreaterThan(1);

        // step 2 : make these as a DTO, and return the list of it.
        List<ProductStockDTO> availableProductDTOList = new ArrayList<>();
        for(Product product : availableItems){
            availableProductDTOList.add(ProductStockDTO.convertToDTO(product));
        }
        return availableProductDTOList;
    }





}
