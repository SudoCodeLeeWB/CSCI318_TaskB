package Jome.Order_Microservice.dto;

import Jome.Order_Microservice.domain.entity.Shipped;

public class ShippedDTO {


    private Long OrderId;
    private boolean delivered;


    protected ShippedDTO(){}

    public ShippedDTO(Shipped shipped){

        this.OrderId = shipped.getOrderId();
        this.delivered = shipped.isDelivered();

    }

    public static ShippedDTO convertTODTO (Shipped shipped){

        return new ShippedDTO(shipped);

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
