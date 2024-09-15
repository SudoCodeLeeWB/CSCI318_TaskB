package Jome.Order_Microservice.domain.entity;

import Jome.Order_Microservice.dto.ProductInOrderDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductInfo {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private String fullName;
    private int quantity;
    protected ProductInfo(){}


    // will be used to  add a new product in the includedProducts
    public ProductInfo( ProductInOrderDTO dto , int quantity ){
        this.productId = dto.getId();
        this.fullName = dto.getFullName();
        this.quantity = quantity;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
