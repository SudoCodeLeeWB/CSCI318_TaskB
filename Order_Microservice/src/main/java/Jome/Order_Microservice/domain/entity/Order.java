package Jome.Order_Microservice.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order {

    @Id
    private Long id;






    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
