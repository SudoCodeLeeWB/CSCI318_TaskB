package Jome.apiGateway.dto;

import Jome.apiGateway.dto.ProductInfoDTO;
import Jome.apiGateway.CompositionObject.Address;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrderDTO {


    private Long customerID;
    private String f_name;
    private String l_name;
    private boolean paid ;

    private List<ProductInfoDTO> includedProductDTO = new ArrayList<>();
    private Address deliveryAddress;

    public CustomerOrderDTO(){}

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
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

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public List<ProductInfoDTO> getIncludedProductDTO() {
        return includedProductDTO;
    }

    public void setIncludedProductDTO(List<ProductInfoDTO> includedProductDTO) {
        this.includedProductDTO = includedProductDTO;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
