package Jome.Customer_Microservice.application;

import Jome.Customer_Microservice.domain.entity.Customer;
import Jome.Customer_Microservice.domain.service.CustomerDomainService;
import Jome.Customer_Microservice.dto.CustomerDTO;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToStdout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerDomainService customerDomainService;


    @Autowired
    public CustomerService(CustomerDomainService customerDomainService) {
        this.customerDomainService = customerDomainService;
    }


    // Use Case 1 : Add new user
    public CustomerDTO addNewUser(CustomerDTO user){

        return customerDomainService.addNewUser(user);

    }

    // Use Case 2 : Update User information
    public CustomerDTO updateUser(Long Id , CustomerDTO customer){

        return customerDomainService.updateUser(Id , customer);

    }


    // To be used in other microservice
    public CustomerDTO getUser(Long Id){

        return customerDomainService.getUser(Id);

    }

//



}
