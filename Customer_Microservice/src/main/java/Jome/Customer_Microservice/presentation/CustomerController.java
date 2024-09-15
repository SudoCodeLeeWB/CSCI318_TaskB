package Jome.Customer_Microservice.presentation;

import Jome.Customer_Microservice.application.CustomerService;
import Jome.Customer_Microservice.domain.entity.Customer;
import Jome.Customer_Microservice.dto.CustomerDTO;
import Jome.Customer_Microservice.dto.CustomerPreferenceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {


    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){this.customerService = customerService;}




    // Use Case 1 : Add new user
    @PostMapping("/create")
    public ResponseEntity<CustomerDTO>addNewUser( @RequestBody CustomerDTO customerDTO){
       try{
           CustomerDTO result = customerService.addNewUser(customerDTO);
           return ResponseEntity.ok(result);
       }
       catch(Exception e){
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }


    // Use Case 2 : Update User information
    @PatchMapping("/patch/{customer_id}")
    public ResponseEntity<CustomerDTO> updateUser( @PathVariable Long customer_id , @RequestBody CustomerDTO customerDTO){
        try{
            CustomerDTO result  = customerService.updateUser(customer_id, customerDTO);
            return ResponseEntity.ok(result);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/get/{customer_id}")
    public ResponseEntity<CustomerDTO> getUser ( @PathVariable Long customer_id){

        try {
            CustomerDTO result = customerService.getUser(customer_id);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getPreference/{customer_id}")
    public ResponseEntity<CustomerPreferenceDTO> getPreferecne( @PathVariable Long customer_id){
        try {
            CustomerPreferenceDTO result = customerService.getPreference(customer_id);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }



}
