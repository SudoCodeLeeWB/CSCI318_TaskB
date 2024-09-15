package Jome.Order_Microservice.dto;

import Jome.Order_Microservice.domain.entity.ProductInfo;

public class ProductInfoDTO {


    private Long productId;
    private String fullName;
    private int quantity;


    public ProductInfoDTO(){}

    public ProductInfoDTO( ProductInfo productInfo) {
        this.productId = productInfo.getProductId();
        this.fullName = productInfo.getFullName();
        this.quantity = productInfo.getQuantity();
    }


    public static ProductInfoDTO convertToDTO(ProductInfo productInfo){
        return new ProductInfoDTO(productInfo);
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
