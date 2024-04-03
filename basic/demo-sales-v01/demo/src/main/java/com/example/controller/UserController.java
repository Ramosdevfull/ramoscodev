package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/users/api/v1")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@RequestParam Long id) {
        return userRepository.findById(id);
    }
    

    @PostMapping("/create")
    public User createUser(@RequestBody User userx) {
        return userRepository.save(userx);
    }

    @Transactional
    @PutMapping("update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User entity) {
        Optional<User> usr = userRepository.findById(id);
        if (usr.isPresent()) {
            User originalUser = usr.get();

            if (Objects.nonNull(entity.getName()) && !"".equalsIgnoreCase(entity.getName())) {
                originalUser.setName(entity.getName());
            }
            if (Objects.nonNull(entity.getEmail()) && "".equalsIgnoreCase(entity.getEmail())) {
                originalUser.setEmail(entity.getEmail());
            }
            return userRepository.save(originalUser);
        }
        
        
        return null;
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        String msg = "ID não encontrado!";
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return "user deleted successfully";
        }
        return msg;
    }
}
