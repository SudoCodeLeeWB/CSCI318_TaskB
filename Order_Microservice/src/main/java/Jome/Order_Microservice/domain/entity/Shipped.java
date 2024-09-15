package Jome.Order_Microservice.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Shipped {
    @Id
    private Long id;

    // for storing the Order id
    private Long OrderId;
    private boolean delivered;

    protected Shipped(){}

    public Shipped( Long orderId){

        this.OrderId = orderId;
        this.delivered = false;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long orderId) {
        OrderId = orderId;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}
