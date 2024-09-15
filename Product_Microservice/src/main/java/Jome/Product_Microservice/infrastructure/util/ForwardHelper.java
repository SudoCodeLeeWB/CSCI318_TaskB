package Jome.Product_Microservice.infrastructure.util;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


public class ForwardHelper {

    // for get  & delete
    public static <T> ResponseEntity<T> forwardRequest(RestTemplate restTemplate, String serviceUrl, String endpoint, HttpMethod method, Class<T> responseType) {
        String fullUrl = serviceUrl + endpoint;
        try {
            ResponseEntity<T> response = restTemplate.exchange(fullUrl, method, null, responseType);
            return response;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static <T, B> ResponseEntity<T> forwardRequest(RestTemplate restTemplate, String serviceUrl, String endpoint, HttpMethod method, B requestBody, Class<T> responseType) {
        String fullUrl = serviceUrl + endpoint;
        try {
            HttpEntity<B> requestEntity = new HttpEntity<>(requestBody);
            ResponseEntity<T> response = restTemplate.exchange(fullUrl, method, requestEntity, responseType);

            // Remove the Transfer-Encoding header before returning to the client
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.putAll(response.getHeaders());
            responseHeaders.remove(HttpHeaders.TRANSFER_ENCODING);

            return ResponseEntity.status(response.getStatusCode())
                    .headers(responseHeaders)
                    .body(response.getBody());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
