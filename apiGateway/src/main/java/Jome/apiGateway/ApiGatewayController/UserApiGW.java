package Jome.apiGateway.ApiGatewayController;

import Jome.apiGateway.ApiGatewayController.ApiGatewayHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/users")
public class UserApiGW {

    private final RestTemplate restTemplate;

    @Value("user.service.url")
    private String userMicroServiceUrl;


    @Autowired
    public UserApiGW(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



//    // Use Case 1 : Add new user
//    @PostMapping("/create")
//    public ResponseEntity<Object> addUser(){}
//
//
//    // Use Case 2 : Update User information
//    @PatchMapping("/patch")
//    public ResponseEntity<Object> updateUser(){}
//






}
