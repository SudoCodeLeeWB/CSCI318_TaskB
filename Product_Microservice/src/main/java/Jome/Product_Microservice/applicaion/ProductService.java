package Jome.Product_Microservice.applicaion;

import Jome.Product_Microservice.domain.entity.Product;
import Jome.Product_Microservice.domain.service.ProductDomainService;
import Jome.Product_Microservice.dto.ProductDTO;
import Jome.Product_Microservice.dto.ProductInOrderDTO;
import Jome.Product_Microservice.dto.ProductStockDTO;
import Jome.Product_Microservice.infrastructure.event.PaymentCompleteEvent;
import Jome.Product_Microservice.infrastructure.event.ProductInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductDomainService productDomainService;

    @Autowired
    public ProductService(ProductDomainService productDomainService) {
        this.productDomainService = productDomainService;
    }


    /*
    * TODO :
    * 1. implement the actual business logic here ( divide the usecase into smaller tasks )
    *  => the method is a usecase and the inner logic is a subdivided tasks for the usecase.
    * 2. include required menthods & repositories
    *   Ex) api call for other microservice --> call other microservice | call the repository ( done )
    *
    * */


    // Use Case 1 : Add new Product => return the saved product DTO as a result
    public ProductDTO addNewProduct(ProductDTO newProductDTO){  // consideration : we do not provide id normally,


        // 1. convert the product Dto into Product aggregate
        Product newProduct = Product.convertTOAggregate(newProductDTO);

        // 2. Save it in the repository
        Product savedClass = productDomainService.addNewProduct(newProduct);

        // 3. Wrap up as DTO and return
        return ProductDTO.convertToDTO(savedClass);

    }


    // Use case 2 : Update the Product Stock
   public ProductStockDTO updateProductStock(Long productId, int quantity ){

        Product result = productDomainService.updateProductStock(productId , quantity);

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
        List<Product> products = productDomainService.categoryProducts(category);

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
        List<Product> availableItems = productDomainService.availableItems();
        // step 2 : make these as a DTO, and return the list of it.
        List<ProductStockDTO> availableProductDTOList = new ArrayList<>();
        for(Product product : availableItems){
            availableProductDTOList.add(ProductStockDTO.convertToDTO(product));
        }
        return availableProductDTOList;
    }


    // returns the product information
    public ProductInOrderDTO findProduct(Long productId){

        return productDomainService.findProduct(productId);
    }


    // deducts the product stock
    public void deductStock(PaymentCompleteEvent event){

        for (ProductInfoDTO product : event.getProducts()){
            productDomainService.deductStock(product.getProductId(), product.getQuantity());
        }


    }


}
