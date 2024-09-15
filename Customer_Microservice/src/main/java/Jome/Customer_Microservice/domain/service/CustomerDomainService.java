package Jome.Customer_Microservice.domain.service;

import Jome.Customer_Microservice.domain.entity.Customer;
import Jome.Customer_Microservice.dto.CustomerDTO;
import Jome.Customer_Microservice.infrastructure.persistence.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDomainService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerDomainService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public CustomerDTO addNewUser(CustomerDTO user){

        // 1. convert the user Dto into user aggregate
        Customer newUser = Customer.convertToAggregate(user);

        // 2. Save it into the repository
        Customer savedUser = customerRepository.save(newUser);

        // return the result
        return CustomerDTO.convertToDTO(savedUser);

    }


    public CustomerDTO updateUser(Long Id, CustomerDTO c ){

        Customer update = customerRepository.findById(Id)
                .map(
                        customer -> {
                            // update the customer with customer DTO
                            customer.update(c);

                            // save the modified Aggregate
                            return customerRepository.save(customer);
                        }).orElseThrow( ()-> new RuntimeException("User not found with id : " + Id));  // handle not found

        // wrap up with DTO and return
        return CustomerDTO.convertToDTO(update);


    }


    public CustomerDTO getUser(Long Id){
        try {
            Optional<Customer> foundCustomer = customerRepository.findById(Id);
            if (foundCustomer.isPresent()) {
                return CustomerDTO.convertToDTO(foundCustomer.get());
            } else {
                throw (new RuntimeException("User not found with Id : " + Id));
            }
        }catch ( RuntimeException e ){
            return null;
        }
    }






}
