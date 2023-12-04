package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.project.repository.model.entity.User;
import com.example.project.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {

        //if user exists return null
        if (userRepository.findByEmail(user.getEmail()) != null){
            return null;
        }
        return userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        System.out.println(user.toString());
        if(user == null){
            return null;
        }
        return user;
    }

    public User loginUser(String email){
        User user = userRepository.findByEmail(email);

        if(user != null){
            return user;
        }
        else{
            User badUser = userRepository.findByEmail("baduser@gmail.com");
            return badUser;
        }
    }

    public User registerNewUser(String fName, String lName, String email, String password) {
        User user = new User(fName, lName, email, password);
        user.setPassword(password); // Password should be encrypted before saving
        return userRepository.save(user);
    }

    public User getCurrentUser(String userId){
        return null;
    }

}
