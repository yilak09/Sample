package com.rest.api.restApi.controller;

import com.rest.api.restApi.model.Users;
import com.rest.api.restApi.repo.UserJpaRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @GetMapping(value ="/all")
    public List<Users> findAll(){
        System.out.println("hello I am here "+userJpaRepository.findAll());
        return  userJpaRepository.findAll();
    }

    @GetMapping(value="/{name}")
    public Users findByName(@PathVariable final String name){
        return userJpaRepository.findByName(name);

    }

    @PostMapping(value="/load")
    public Users load(@RequestBody final Users users){
         userJpaRepository.save(users);
        return userJpaRepository.findByName(users.getName());


    }


}
