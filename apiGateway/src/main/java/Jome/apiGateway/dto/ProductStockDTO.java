package Jome.apiGateway.dto;


// A DTO to expose the product stock information
public class ProductStockDTO {

    private String fullName;
    private int stock;


    public ProductStockDTO(){}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
