package Jome.User_Microservice.domain.entity;

import Jome.User_Microservice.domain.valueobject.Address;
import jakarta.persistence.*;

@Entity
public class ServiceUser {

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
    protected ServiceUser(){}

    public ServiceUser(String f_name , String l_name , String email , Address address , String preferenceCategory ){
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.address = address;
        this.preferenceCategory = preferenceCategory;

    }

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
