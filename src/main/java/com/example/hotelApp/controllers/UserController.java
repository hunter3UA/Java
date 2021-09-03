package com.example.hotelApp.controllers;

import com.example.hotelApp.dto.UserCreateDTO;
import com.example.hotelApp.dto.UserDTO;

import com.example.hotelApp.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user")
    public UserDTO createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return userService.createUser(userCreateDTO);
    }

    @GetMapping("/user/all")
    public List<UserDTO> allUsers(){
        return userService.allUsers();

    }
    @GetMapping("/user/{userID}")
    public UserDTO byID(@PathVariable(name ="userID")Integer userID){
        return userService.byID(userID);
    }

    @PutMapping("/user")
    public UserDTO Update(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }


    @PutMapping("/user/{userID}")
    public Boolean DeleteByID(@PathVariable(name ="userID")Integer userID){
        return userService.deleteByID(userID);
    }
}
