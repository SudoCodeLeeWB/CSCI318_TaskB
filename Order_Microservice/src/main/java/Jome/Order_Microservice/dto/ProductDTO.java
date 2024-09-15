// consideration : will using the DTO reasonable? can I just handle it as a object?
// => yes, too show the passed product as a return value , the javeascript converter requries getters and setters
// to properly transform it as a json object and return it as a response.


package Jome.Order_Microservice.dto;

public class ProductDTO {

    // add elements for the DTO object here
    // Things to be exposed : ( everything else id )
    // 1. full name
    // 2. description
    // 3. price
    // 4. stock
    // 5. category
    private String fullName;
    private String description;
    private int price ;
    private int stock;
    private String category;

    // constructor
    public ProductDTO(){}

    // static method to convert a class to DTO

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
