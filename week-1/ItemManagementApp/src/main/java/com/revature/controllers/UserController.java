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

//    4- As a user, I can view all Items
//    6- As a user, I can view a singular Item by its ID
//      (HINT: Use Path Params to select a Item by its ID)
//    7- As a user, I can update a Item (Change the name or other properties)
//    8- As a user, I can delete a Item by its ID
//      (HINT: Use Path Params to select a Item by its ID)
//    5- As a user, I can view the Items associated with my account


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

    // 3- As a user, I can create a new Item






}
