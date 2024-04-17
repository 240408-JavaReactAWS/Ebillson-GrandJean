package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    // Sanity Check
    @GetMapping("/usersample")
    public User getUserSample(){
        return new User(1, "BillGJ", "pass1234");
    }


    //  1- As a user, I can create an account to hold my Items
    @PostMapping("/register")
    public ResponseEntity<User> createAccount(@RequestBody User user){

        if(userService.findUserByName(user.getName()) != null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        boolean isNameBlank = user.getName().isBlank();
        int passwordLength = user.getPassword().length();

        // enforcing password of min length of 4 characters and prevent blank name
        if(!isNameBlank && passwordLength >= 4){
            User userCreated = userService.createUser(user);
            return new ResponseEntity<User>(userCreated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //  2- As a user, I can login to my account (which is stored in the database)
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        User userToLogin = userService.login(user);
        if(userToLogin == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<User>(userToLogin, HttpStatus.OK);
    }


}
