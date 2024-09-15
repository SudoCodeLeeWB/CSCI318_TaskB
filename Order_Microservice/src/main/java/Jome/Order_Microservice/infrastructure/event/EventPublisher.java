package Jome.Order_Microservice.infrastructure.event;

import Jome.Order_Microservice.domain.event.PaymentCompleteEvent;
import Jome.Order_Microservice.infrastructure.util.ForwardHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EventPublisher {
    private final RestTemplate restTemplate;

    @Value("${product.service.url}")
    private String productMicroServiceUrl;

    @Value("order.service.url")
    private String orderMicroServiceUrl;

    @Value("user.service.url")
    private String userMicroServiceUrl;

    @Autowired
    public EventPublisher(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void deductEventPublish(PaymentCompleteEvent event){
        String path = productMicroServiceUrl + "/patch/deduct";
        ForwardHelper.forwardRequest(restTemplate, productMicroServiceUrl , path , HttpMethod.PATCH , event , Void.class);
    }



}
