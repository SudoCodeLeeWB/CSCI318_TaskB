package Jome.apiGateway.ApiGatewayController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


// Rest Controller for domain Product
@RestController
@RequestMapping("/api/products")
public class ProductApiGW {

    private final RestTemplate restTemplate;

    // Inject the microservice url from applicaion.properties
    @Value("${product.service.url}")
    private String productMicroServiceUrl;

    @Autowired
    public ProductApiGW(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    /* TODO :
    * Implement the timeout => inside of the restTemplate config
    * Add more usecases routing to the microservices
    * */


    // sample call for connection testing
    @GetMapping("getProduct/{productId}")
    public ResponseEntity<String> getProductById(@PathVariable Long productId){

        // the call should be same from the microservice @GetMapping
        // The Url is embedded in the Value as an application properties
        String productServiceUrl = productMicroServiceUrl + "/getProduct/" + productId;

        try{
            ResponseEntity<String> returnValue =  restTemplate.getForEntity(productServiceUrl , String.class);

            // condition where the status code is 200, but there are no contents inside
            if(returnValue.getBody() == null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return returnValue;
        }
        catch(Exception ex){
            // if any RestClientException is thrown, will not expose the direct issue to the user.
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    // other rest api calls
    // @GetMapping




}
