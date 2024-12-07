package com.example.music_web.service;

import com.example.music_web.model.User;
import com.example.music_web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userrepository;

    public List<User> getAllUsers(){
        return userrepository.findAll();
    }

    public User getUserById(Long id){
        return userrepository.findById(id).orElse(null);
    }

    public void saveUser(User user){
        userrepository.save(user);
    }
}
