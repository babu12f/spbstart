package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/users")
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getall(){
        return userRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<User> getUser(@PathVariable("name") final String name){
        Optional<List<User>> listOptional = userRepository.findByName(name);

        List<User> users = listOptional
                .orElse(new ArrayList<>());

        return users;
    }

    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable("id") final Integer id){
        return userRepository.findById(id).get();
    }

    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final Integer id, @PathVariable("name") final String name) {
        User user = userRepository.findById(id).get();

        user.setName(name);

        return userRepository.save(user);
    }
}
