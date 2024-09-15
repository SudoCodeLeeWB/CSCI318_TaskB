package Jome.apiGateway.dto;


public class ShippedDTO {


    private Long OrderId;
    private boolean delivered;


    protected ShippedDTO(){}

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
