package Jome.apiGateway.ApiGatewayController;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class ApiGatewayHelper {

    // for get  & set
    public static <T> ResponseEntity<T> forwardRequest(RestTemplate restTemplate, String serviceUrl, String endpoint, HttpMethod method, Class<T> responseType) {
        String fullUrl = serviceUrl + endpoint;
        try {
            ResponseEntity<T> response = restTemplate.exchange(fullUrl, method, null, responseType);
            return response;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // for post / patch ( includes RequestBody )
    public static <T, B> ResponseEntity<T> forwardRequest(RestTemplate restTemplate, String serviceUrl, String endpoint, HttpMethod method, B requestBody, Class<T> responseType) {
        String fullUrl = serviceUrl + endpoint;
        try {
            HttpEntity<B> requestEntity = new HttpEntity<>(requestBody);
            ResponseEntity<T> response = restTemplate.exchange(fullUrl, method, requestEntity, responseType);
            return response;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
