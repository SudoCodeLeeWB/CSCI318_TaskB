package Jome.Product_Microservice.infrastructure.event;



import java.util.List;

public class PaymentCompleteEvent {

    private Long customerId;
    private List<ProductInfoDTO> products;


    public PaymentCompleteEvent(){}


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


