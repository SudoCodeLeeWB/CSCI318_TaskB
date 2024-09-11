package Jome.Order_Microservice.domain.valueobject;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String state;
    private String country;
    private String postCode;


    // SpringJpa and hibernate will use it, but others will not use it
    protected Address(){}

    public Address(String street , String country, String state , String postCode){

        this.street = street;
        this.country = country;
        this.state = state;
        this.postCode = postCode;

    }





    // getters
    public String getStreet() {
        return street;
    }

    public String getCountry() {
        return country;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getState() {
        return state;
    }
}
