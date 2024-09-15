package Jome.Order_Microservice.domain.event;

import Jome.Order_Microservice.domain.entity.CustomerOrder;
import Jome.Order_Microservice.domain.entity.ProductInfo;
import Jome.Order_Microservice.dto.ProductInOrderDTO;
import Jome.Order_Microservice.dto.ProductInfoDTO;

import java.util.ArrayList;
import java.util.List;

public class PaymentCompleteEvent {

    private Long customerId;
    private List<ProductInfoDTO> products;


    public PaymentCompleteEvent(){}

    public PaymentCompleteEvent(CustomerOrder order) {
        this.customerId = order.getCustomerID();
        this.products = new ArrayList<>();

        for (ProductInfo product : order.getIncludedProducts()) {
            this.addProduct(ProductInfoDTO.convertToDTO(product));
        }

    }


    public void addProduct(ProductInfoDTO product) {
        this.products.add(product);
    }

    public void deleteProduct(ProductInfoDTO product) {
        this.products.remove(product);
    }


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<ProductInfoDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInfoDTO> products) {
        this.products = products;
    }
}


