package Jome.Customer_Microservice.application;

import Jome.Customer_Microservice.domain.entity.Customer;
import Jome.Customer_Microservice.dto.CustomerDTO;
import Jome.Customer_Microservice.infrastructure.persistence.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    // Use Case 1 : Add new user
    public CustomerDTO addNewUser(CustomerDTO user){

        // 1. convert the user Dto into user aggregate
        Customer newUser = Customer.convertToAggregate(user);

        // 2. Save it into the repository
        Customer savedUser = customerRepository.save(newUser);

        // return the result
        return CustomerDTO.convertToDTO(savedUser);

    }

    // Use Case 2 : Update User information
    public CustomerDTO updateUser(Long Id , CustomerDTO c){

        Customer update = customerRepository.findById(Id)
                .map(
                        customer -> {
                            // update the customer with customer DTO
                            customer.update(c);

                            // save the modified Aggregate
                            return customerRepository.save(customer);
                        }).orElseThrow( ()-> new RuntimeException("User not found with id : " + Id));


        // wrap up with DTO and return
        return CustomerDTO.convertToDTO(update);

    }

//



}
