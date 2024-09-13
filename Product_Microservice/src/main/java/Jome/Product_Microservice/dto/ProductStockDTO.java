package Jome.Product_Microservice.dto;
import Jome.Product_Microservice.domain.entity.Product;


// A DTO to expose the product stock information
public class ProductStockDTO {

    private String fullName;
    private int stock;


    public ProductStockDTO(){}
    public ProductStockDTO( Product product){

        this.fullName = product.getFullName();
        this.stock = product.getStock();

    }

    public static ProductStockDTO convertToDTO(Product product){
        return new ProductStockDTO(product);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
