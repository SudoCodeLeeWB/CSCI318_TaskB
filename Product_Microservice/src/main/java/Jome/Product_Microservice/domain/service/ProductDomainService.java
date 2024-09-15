package Jome.Product_Microservice.domain.service;

import Jome.Product_Microservice.domain.entity.Product;
import Jome.Product_Microservice.dto.ProductDTO;
import Jome.Product_Microservice.dto.ProductInOrderDTO;
import Jome.Product_Microservice.infrastructure.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDomainService {


    private final ProductRepository productRepository;


    @Autowired
    public ProductDomainService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    public ProductInOrderDTO findProduct (Long productId){

        // find the product information and return it as a DTO
        Product result = productRepository.findById(productId).orElseThrow(RuntimeException::new);
        return ProductInOrderDTO.convertToDTO(result);

    }


    public Product addNewProduct(Product newProduct){
        //save() expects Aggregate | Save this new product into DataBase
         return  productRepository.save(newProduct);
    }


    public Product updateProductStock(Long productId , int quantity ){

        // Step 1 : Retrieve the original data from product Repository
        Product result =  productRepository.findById(productId)
                .map(
                        product -> {

                            // Step 2 : modify the aggregate
                            product.setStock(quantity);

                            // Step 3 : Save the modified Aggregate
                            return productRepository.save(product);
                        }).orElseThrow( () -> new RuntimeException("Product Not found with id " + productId));

        return result;
    }


    public List<Product> availableItems(){

        return productRepository.findByStockGreaterThan(1);

    }


    public List<Product> categoryProducts( String category){

        return productRepository.findByCategory(category);

    }


    public void deductStock(Long productId, int quantity){

        // find the product
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // deduct stock => if not enough then throw error
        if (product.getStock() < quantity) {
            throw new IllegalStateException("Not enough stock available");
        }

        product.setStock(product.getStock() - quantity);
        productRepository.save(product);


    }

}
