package com.taskflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskflow.model.User;
import com.taskflow.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
        return userRepository.save(user);
    }

    public User login(String email, String password){
        User user = userRepository.findByEmail(email)
        .orElseThrow(()-> new RuntimeException("Invalid email or password"));
        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Invalid email or password"); //throws exception if user is not found
        }

        return user;
    }

    public User updateProfile(Long id, User updatedUserData){
        return userRepository.findById(id).map(user -> { //.map is called only if the user is found
            user.setUsername(updatedUserData.getUsername());
            user.setEmail(updatedUserData.getEmail());
            user.setPassword(updatedUserData.getPassword());
            return  userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id; " + id));
    }
}