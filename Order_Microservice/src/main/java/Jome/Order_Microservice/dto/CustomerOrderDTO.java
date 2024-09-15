package Jome.Order_Microservice.dto;


import Jome.Order_Microservice.domain.entity.CustomerOrder;
import Jome.Order_Microservice.domain.entity.ProductInfo;
import Jome.Order_Microservice.domain.valueobject.Address;

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
    public CustomerOrderDTO(CustomerOrder customerOrder){

        this.customerID = customerOrder.getCustomerID();
        this.f_name = customerOrder.getF_name();
        this.l_name = customerOrder.getF_name();
        this.paid = customerOrder.isPaid();
        this.deliveryAddress = customerOrder.getDeliveryAddress();

        for(ProductInfo product :customerOrder.getIncludedProducts()){
            this.addProduct(ProductInfoDTO.convertToDTO(product));
        }


    }

    public static CustomerOrderDTO convertToDTO(CustomerOrder customerOrder){
        return new CustomerOrderDTO(customerOrder);
    }

    public void addProduct(ProductInfoDTO product){this.includedProductDTO.add(product);}
    public void deleteProduct(ProductInfoDTO product){this.includedProductDTO.remove(product);}


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
