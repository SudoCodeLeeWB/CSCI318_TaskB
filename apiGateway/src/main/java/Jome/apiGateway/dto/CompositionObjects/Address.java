package Jome.apiGateway.CompositionObject;


public class Address {
    private String street;
    private String state;
    private String country;
    private String postCode;

    protected Address(){}
    
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
