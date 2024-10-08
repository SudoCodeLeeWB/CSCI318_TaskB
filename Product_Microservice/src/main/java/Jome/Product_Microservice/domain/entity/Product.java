package Jome.Product_Microservice.domain.entity;

import Jome.Product_Microservice.dto.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String description;
    private int price;
    private int stock;
    private String category;



    // constructor
    protected Product(){}

    public Product(String fullName , String description , int stock , int price , String category ){
        this.id = null;
        this.fullName = fullName;
        this.description = description;
        this.stock= stock;
        this.price = price;
        this.category = category;
    }



    // Actually valuable methods TODO for business logic

    public boolean isAvailable(){
        return stock > 0 ;
    }


    public static Product convertTOAggregate(ProductDTO productDTO){
        return new Product(
                productDTO.getFullName(),
                productDTO.getDescription(),
                productDTO.getStock(),
                productDTO.getPrice(),
                productDTO.getCategory()
        );
    }

    // Getters and setters

    // No setter for id => Automatically generated in the Database
    public Long getId() {
        return id;
    }

    public void setFullName(String name){
        this.fullName = name;
    }

    public String getFullName(){
        return fullName;
    }

    public String getDescription(){
        return description;
    }

    public  void setDescription(){
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
