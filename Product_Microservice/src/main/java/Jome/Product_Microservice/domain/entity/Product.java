package Jome.Product_Microservice.domain.entity;

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
    private int quantity;
    private String description;
    private String category;


    // constructor => needs to be implemented later. // overload

    public Product(){}

    public Product( String fullName) {
        this.fullName = fullName;
        this.quantity = 0;  // when init =>  the quantity is 0
        this.description = "";
    }

    public Product(String fullName , String description ){
        this.fullName = fullName;
        this.description = description;
        this.quantity = 0;
    }

    public Product(String fullName , String description , int quantity ){
        this.fullName = fullName;
        this.description = description;
        this.quantity= quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // this needs to be hidden?
    public Long getId() {
        return id;
    }

    public void setFullName(String name){
        this.fullName = name;
    }

    public String getFullName(){
        return fullName;
    }

    public int getQuantity(){
        return quantity;
    }
    public void setQuantity( int quantity){
        this.quantity = quantity;
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

}
