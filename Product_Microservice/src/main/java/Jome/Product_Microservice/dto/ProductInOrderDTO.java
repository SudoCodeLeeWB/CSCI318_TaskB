package Jome.Product_Microservice.dto;
import Jome.Product_Microservice.domain.entity.Product;

public class ProductInOrderDTO {

    private Long id; // will be used later for retriving the data
    private String fullName;

    public ProductInOrderDTO(){}

    public ProductInOrderDTO(Product product){
        this.id = product.getId();
        this.fullName = product.getFullName();
    }

    public static ProductInOrderDTO convertToDTO(Product product) {
        return  new ProductInOrderDTO(product);
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


}
