package Jome.Product_Microservice.infrastructure.service;

import Jome.Product_Microservice.dto.CustomerPreferenceDTO;
import Jome.Product_Microservice.infrastructure.util.ForwardHelper;
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
public CustomerPreferenceDTO getCustomerInfo (Long customerId ){
     String microServiceMapping = "/getPreference/" + customerId;
    ResponseEntity<CustomerPreferenceDTO> microServiceQueryResult =  ForwardHelper.forwardRequest(restTemplate , userMicroServiceUrl, microServiceMapping, HttpMethod.GET , CustomerPreferenceDTO.class);

    CustomerPreferenceDTO data = microServiceQueryResult.getBody();
    return data;
}








}
