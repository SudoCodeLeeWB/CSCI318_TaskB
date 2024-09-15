package Jome.apiGateway.ApiGatewayController;
import Jome.apiGateway.dto.CustomerDTO;
import Jome.apiGateway.dto.CustomerPreferenceDTO;

import Jome.apiGateway.ApiGatewayController.ApiGatewayHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserApiGW {

    private final RestTemplate restTemplate;

    @Value("${user.service.url}")
    private String userMicroServiceUrl;


    @Autowired
    public UserApiGW(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    // Use Case 1 : Add new user
    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> addUser(@RequestBody CustomerDTO customerDTO){
        String microServiceMapping = "/create";
        return ApiGatewayHelper.forwardRequest(restTemplate, userMicroServiceUrl, microServiceMapping, HttpMethod.POST, CustomerDTO.class);
    
    }


    // Use Case 2 : Update User information
    @PostMapping("/patch/{customerId}")
    public ResponseEntity<CustomerDTO> updateUser(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO){
        String microServiceMapping = "/patch/"+customerId;
        return ApiGatewayHelper.forwardRequest(restTemplate, userMicroServiceUrl, microServiceMapping, HttpMethod.POST, customerDTO, CustomerDTO.class);
    
    }

    @GetMapping("/patch/{customerId}")
    public ResponseEntity<CustomerDTO> updateUser(@PathVariable Long customerId){
        String microServiceMapping = "/add/"+customerId;
        return ApiGatewayHelper.forwardRequest(restTemplate, userMicroServiceUrl, microServiceMapping, HttpMethod.POST, CustomerDTO.class);
    
    }

    @GetMapping("getPreference/{customerId}")
    public ResponseEntity<CustomerPreferenceDTO> getPreferecne(@PathVariable Long customerId){
        String microServiceMapping = "/getPreference/"+customerId;
        return ApiGatewayHelper.forwardRequest(restTemplate, userMicroServiceUrl, microServiceMapping, HttpMethod.POST, CustomerPreferenceDTO.class);
    
    }







}
