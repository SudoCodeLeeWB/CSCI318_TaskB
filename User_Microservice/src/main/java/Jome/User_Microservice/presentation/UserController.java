package Jome.User_Microservice.presentation;

import Jome.User_Microservice.application.UserService;
import Jome.User_Microservice.infrastructure.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController ( UserService userService ){this.userService = userService;}


//    // Use Case 1 : Add new user
//    @PostMapping("/create")(@RequestBody )
//    public ResponseEntity<> addUser(){}
//
//
//    // Use Case 2 : Update User information
//    @PatchMapping("/patch")
//    public ResponseEntity<Object> updateUser(){}
//



}
