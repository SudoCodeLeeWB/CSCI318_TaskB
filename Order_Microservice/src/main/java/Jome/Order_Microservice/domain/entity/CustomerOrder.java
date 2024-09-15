package Jome.Order_Microservice.domain.entity;

import Jome.Order_Microservice.domain.valueobject.Address;
import Jome.Order_Microservice.dto.CustomerDTO;
import Jome.Order_Microservice.dto.ProductDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerID;
    private String f_name;
    private String l_name;

    private boolean paid ;

    @OneToMany
    private List<ProductInfo> includedProducts = new ArrayList<>();

    @Embedded
    private Address deliveryAddress;


    // Constructor  +> Empty constructor required by jpaRepository
    protected CustomerOrder(){}

    public CustomerOrder(Long customerID ,CustomerDTO customer ){
        this.customerID = customerID;
        this.f_name = customer.getL_name();
        this.l_name = customer.getL_name();
        this.deliveryAddress = customer.getAddress();
        this.paid = false;  // must be false at init
    }


    public List<ProductInfo> getIncludedProducts(){
        return includedProducts;
    }

    // Add a new product into the order
    public void addProduct(ProductInfo product){
        this.includedProducts.add(product);
    }

    // Delete a product in the order
    public void deleteProduct(ProductInfo product){
        this.includedProducts.remove(product);
    }

    // Payment is successfully processed
    public void paymentDone(){
        this.paid = true;
    }



    // getters and setters
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public boolean isPaid() {
        return paid;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
