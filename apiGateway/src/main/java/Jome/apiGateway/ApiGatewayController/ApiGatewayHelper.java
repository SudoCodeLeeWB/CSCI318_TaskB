package Jome.apiGateway.ApiGatewayController;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class ApiGatewayHelper {

    // for get  & set
    public static <T> ResponseEntity<T> forwardRequest(RestTemplate restTemplate, String serviceUrl, String endpoint, HttpMethod method, Class<T> responseType) {
        String fullUrl = serviceUrl + endpoint;
        try {
            // print something here (this prints)
            System.out.println(restTemplate.exchange(fullUrl, method, null, responseType));
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
