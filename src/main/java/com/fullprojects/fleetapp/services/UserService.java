package com.fullprojects.fleetapp.services;


import com.fullprojects.fleetapp.models.User;

import com.fullprojects.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //Return List of countries
    public List<User> getUsers(){
        return userRepository.findAll();
    };

    //add/save Countries to database
    public void save( User user){

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    //get by id
//    public Optional<User> findById(int id){
//        return userRepository.findById(id);
//    }

    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
