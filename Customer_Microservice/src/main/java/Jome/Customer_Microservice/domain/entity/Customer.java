package Jome.Customer_Microservice.domain.entity;

import Jome.Customer_Microservice.domain.valueobject.Address;
import Jome.Customer_Microservice.dto.CustomerDTO;
import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String f_name;
    private String l_name;
    private String email;
    @Embedded
    private Address address;
    private String preferenceCategory;

    // constructor
    protected Customer(){}

    public Customer(String f_name , String l_name , String email , Address address , String preferenceCategory ){
        this.id = null;
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.address = address;
        this.preferenceCategory = preferenceCategory;

    }


    public static Customer convertToAggregate(CustomerDTO customerDTO){

        return new Customer(
                customerDTO.getF_name(),
                customerDTO.getL_name(),
                customerDTO.getEmail(),
                customerDTO.getAddress(),
                customerDTO.getPreferenceCategory()
        );

    }

    public void update(CustomerDTO customerDTO){

                 this.f_name = customerDTO.getF_name();
                this.l_name = customerDTO.getL_name();
                this.email = customerDTO.getEmail();
                this.address = customerDTO.getAddress();
                this.preferenceCategory = customerDTO.getPreferenceCategory();

    }


    // getters and setters

    public Long getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPreferenceCategory() {
        return preferenceCategory;
    }

    public void setPreferenceCategory(String preferenceCategory) {
        this.preferenceCategory = preferenceCategory;
    }
}
