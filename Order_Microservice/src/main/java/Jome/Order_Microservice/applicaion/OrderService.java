package Jome.Order_Microservice.applicaion;


import Jome.Order_Microservice.infrastructure.services.ApplicationHelperSevice;
import Jome.Order_Microservice.domain.entity.CustomerOrder;
import Jome.Order_Microservice.domain.entity.Shipped;
import Jome.Order_Microservice.domain.service.OrderDomainService;
import Jome.Order_Microservice.dto.CustomerDTO;
import Jome.Order_Microservice.dto.CustomerOrderDTO;
import Jome.Order_Microservice.dto.ProductInOrderDTO;
import Jome.Order_Microservice.dto.ShippedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ApplicationHelperSevice applicationHelperSevice;
    private final OrderDomainService orderDomainService;

    @Autowired
    public OrderService(ApplicationHelperSevice applicationHelperSevice, OrderDomainService orderDomainService) {
        this.applicationHelperSevice = applicationHelperSevice;
        this.orderDomainService = orderDomainService;
    }



    // Use case 1 : Add a new product to the order
    // change it into CustomerOrderDTO later
    public CustomerOrderDTO addNewProductToOrder(Long customerId, Long productId , int quantity){

        // 1. call required information from other microservice
        // query to the customer microservice adn get the customer information ( for the address and name .. )
        CustomerDTO currentCustomer = applicationHelperSevice.getCustomerInfo(customerId);

        // query to the product microservice and get the product information ( for the product namd and quantity )
        ProductInOrderDTO newProduct = applicationHelperSevice.getProductData(productId);

        // 2. Let the domain service do the work
        CustomerOrder result = orderDomainService.addNewProductToOrder( customerId,currentCustomer , newProduct , quantity);
        return CustomerOrderDTO.convertToDTO(result);

    }


    // Use case 2 : place order => domain service, works with two aggregates + event
    public ShippedDTO placeOrder (Long orderId){
        // set the order into order paid
        // change add the Customer order into Shipped Aggregate
        CustomerOrder paidOrder = orderDomainService.processPayment(orderId);
        if(paidOrder != null){
            Shipped shippedOrder = orderDomainService.shipOrder(orderId);

            // event : alert to the product microservice
            orderDomainService.PaymentCompleteAlert(paidOrder);
            return ShippedDTO.convertTODTO(shippedOrder);
        }
        else
            return null;

    }


    // Use case 3 : Mark the order as delivered
    public ShippedDTO deliveryFinish(Long shippedId){
        Shipped delivered = orderDomainService.delivered(shippedId);
        if(delivered != null){
            return ShippedDTO.convertTODTO(delivered);
        }
        else
            return null;
    }


    // partial methods to implement the major usecase


}
