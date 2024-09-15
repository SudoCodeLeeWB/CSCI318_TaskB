package Jome.Order_Microservice.domain.service;


import Jome.Order_Microservice.domain.entity.CustomerOrder;
import Jome.Order_Microservice.domain.entity.ProductInfo;
import Jome.Order_Microservice.domain.entity.Shipped;
import Jome.Order_Microservice.domain.event.PaymentCompleteEvent;
import Jome.Order_Microservice.dto.CustomerDTO;
import Jome.Order_Microservice.dto.ProductInOrderDTO;
import Jome.Order_Microservice.infrastructure.event.EventPublisher;
import Jome.Order_Microservice.infrastructure.persistence.OrderRepository;
import Jome.Order_Microservice.infrastructure.persistence.ShippedRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDomainService {


    private final OrderRepository orderRepository;
    private final ShippedRepository shippedRepository;
    private final EventPublisher eventPublisher;


    public OrderDomainService(OrderRepository orderRepository, ShippedRepository shippedRepository, EventPublisher eventPublisher) {
        this.orderRepository = orderRepository;
        this.shippedRepository = shippedRepository;
        this.eventPublisher = eventPublisher;
    }




    public CustomerOrder addNewProductToOrder( Long customerId , CustomerDTO currentCustomer , ProductInOrderDTO newProduct , int quantity){


    CustomerOrder shoppingCart;

    // 1. look for if there is a order ( with the same customer id ) with no payment done
    // if there is an order with is_paid == false , then it is a Working Order
    // if there are no empty order with is_paid == false, then generate a new order
    Optional<CustomerOrder> recentOrder = orderRepository.findFirstByCustomerIDAndPaidFalse(customerId);
    shoppingCart = recentOrder.orElseGet(() -> new CustomerOrder(customerId, currentCustomer));


    // 2. Adding a new product
    // create a new product info and save the data using ProductInOrderDTO and quantity
    // add a new productInfo to the shopping cart
    ProductInfo formattedProductInfo = new ProductInfo(newProduct , quantity);
    shoppingCart.addProduct(formattedProductInfo);
    // store this shoppingCart into database
    CustomerOrder stored  =  orderRepository.save(shoppingCart);
        return stored;
    }


    public CustomerOrder processPayment( Long orderId ){
        return orderRepository.findById(orderId)
                .map(
                        customerOrder -> {

                            // modify the aggregate
                            customerOrder.paymentDone();
                            return orderRepository.save(customerOrder);
                        }).orElseThrow( () -> new RuntimeException("order Not found= with id : " + orderId));
    }


    public Shipped shipOrder(Long orderId){

        Shipped newShip = new Shipped(orderId);
        return shippedRepository.save(newShip);

    }


    @Transactional
    public void PaymentCompleteAlert(CustomerOrder order){
        PaymentCompleteEvent event = new PaymentCompleteEvent(order);
        eventPublisher.deductEventPublish(event);

    }

    public Shipped delivered (Long shippedId){
        return shippedRepository.findById(shippedId)
                .map(
                        shipped -> {

                            // modify the aggregate
                            shipped.setDelivered(true);
                            return shippedRepository.save(shipped);
                        }).orElseThrow( () -> new RuntimeException("order Not found= with id : " + shippedId));
    }




}
