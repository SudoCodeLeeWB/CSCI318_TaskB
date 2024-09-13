package Jome.Customer_Microservice.dto;

import Jome.Customer_Microservice.domain.entity.Customer;
import Jome.Customer_Microservice.domain.valueobject.Address;
import jakarta.persistence.Embedded;

public class CustomerDTO {
    // elements that will be exposed :
    // f_name
    // l_name
    // email
    // address
    // preferenceCategory

    private String f_name;
    private String l_name;
    private String email;
    @Embedded
    private Address address;
    private String preferenceCategory;

    protected  CustomerDTO(){}

    public CustomerDTO(Customer user){
        this.f_name = user.getF_name();
        this.l_name = user.getL_name();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.preferenceCategory = user.getPreferenceCategory();
    }


    public static CustomerDTO convertToDTO(Customer user){
        return new CustomerDTO(user);
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
