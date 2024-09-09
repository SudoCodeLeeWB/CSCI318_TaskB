package Jome.Product_Microservice.dto;

import Jome.Product_Microservice.domain.entity.Product;

public class ProductDTO {

    // add elements for the DTO object here
    // ex) private int productId;

    private String fullName;
    private String description;
    private int quantity;
    public ProductDTO(){}

    public ProductDTO(String fullName , String description){
        this.fullName = fullName;
        this.description = description;
        this.quantity = 0;
    }

    public ProductDTO(String fullName , int quantity){
        this.fullName = fullName;
        this.quantity = quantity;
        this.description = "";
    }

    // static method to convert a class to DTO
    public static ProductDTO convertToDTO(Product product){
        return new ProductDTO( product.getFullName() , product.getDescription());
    }

    // static method to convert a class to Dto, with quantity
    public static ProductDTO convertToDTO_quantity(Product product){
        return new ProductDTO( product.getFullName() , product.getQuantity());
    }


    // setters are not needed, since this dto is for hiding the information
    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity(){
        return quantity;
    }
}
