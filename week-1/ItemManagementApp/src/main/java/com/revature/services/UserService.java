package com.revature.services;


import com.revature.models.User;
import com.revature.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User findUserByName(String name){
        Optional<User> userToFind = userRepository.findByName(name);
        return userToFind.orElse(null);
    }


    public User login(User user){

        User userToLogin = findUserByName(user.getName());

        if(userToLogin != null) {
            if (userToLogin.getPassword().equals(user.getPassword()))
                return userToLogin;
        }

        return null;
    }




}
