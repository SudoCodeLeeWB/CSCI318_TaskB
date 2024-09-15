package Jome.Order_Microservice.infrastructure.services;

import Jome.Order_Microservice.dto.CustomerDTO;
import Jome.Order_Microservice.dto.ProductInOrderDTO;
import Jome.Order_Microservice.infrastructure.util.ForwardHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApplicationHelperSevice {

 private final RestTemplate restTemplate;

    @Value("${product.service.url}")
    private String productMicroServiceUrl;

    @Value("${order.service.url}")
    private String orderMicroServiceUrl;

    @Value("${user.service.url}")
    private String userMicroServiceUrl;

 @Autowired
    public ApplicationHelperSevice(RestTemplate restTemplate){
     this.restTemplate = restTemplate;
 }

 // for use case 1
 public ProductInOrderDTO getProductData (Long productId ){
     String microServiceMapping = "/get/" + productId;
     ResponseEntity<ProductInOrderDTO> microServiceQueryResult =  ForwardHelper.forwardRequest(restTemplate , productMicroServiceUrl, microServiceMapping, HttpMethod.GET , ProductInOrderDTO.class);

     ProductInOrderDTO data = microServiceQueryResult.getBody();
     return data;
 }

public CustomerDTO getCustomerInfo (Long customerId ){
     String microServiceMapping = "/get/" + customerId;
    ResponseEntity<CustomerDTO> microServiceQueryResult =  ForwardHelper.forwardRequest(restTemplate , userMicroServiceUrl, microServiceMapping, HttpMethod.GET , CustomerDTO.class);

    CustomerDTO data = microServiceQueryResult.getBody();
    return data;
}








}
