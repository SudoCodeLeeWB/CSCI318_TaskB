package Jome.apiGateway.dto;

public class ProductInOrderDTO {

    private Long id; // will be used later for retriving the data
    private String fullName;


    public ProductInOrderDTO(){}


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
