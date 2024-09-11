package Jome.Order_Microservice.domain.entity;

import Jome.Order_Microservice.domain.valueobject.Address;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerID;

    private boolean paid ;

    @ElementCollection
    private List<Long> includedProductIDs = new ArrayList<>();

    @Embedded
    private Address deliveryAddress;


    // Constructor  +> Empty constructor required by jpaRepository
    protected CustomerOrder(){}

    public CustomerOrder(Long customerID, Address deliveryAddress ){
        this.customerID = customerID;
        this.deliveryAddress = deliveryAddress;
        this.paid = false;  // must be always false
    }


    // Business rules / methods


    // Add a new product into the order
    public void addProductId(Long id){
        this.includedProductIDs.add(id);
    }

    // Delete a product in the order
    public void deleteProduct(Long id){
        this.includedProductIDs.remove(id);
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

}
