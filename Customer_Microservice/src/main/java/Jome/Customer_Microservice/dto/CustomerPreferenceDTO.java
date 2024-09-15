package Jome.Customer_Microservice.dto;


import Jome.Customer_Microservice.domain.entity.Customer;

public class CustomerPreferenceDTO {

    private String preferenceCategory;

    public CustomerPreferenceDTO(){}


    public CustomerPreferenceDTO( CustomerDTO customer){

        this.preferenceCategory = customer.getPreferenceCategory();
    }


    public String getPreferenceCategory() {
        return preferenceCategory;
    }

    public void setPreferenceCategory(String preferenceCategory) {
        this.preferenceCategory = preferenceCategory;
    }
}
