package com.example.hotelApp.controllers;


import com.example.hotelApp.dto.UserPasswordChangeDTO;
import com.example.hotelApp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPasswordController {


    @Autowired
    public IUserService userService;


    @PutMapping("/userPassword")
    public Boolean changePassword(@RequestBody UserPasswordChangeDTO userPasswordChangeDTO){
        return userService.updatePassword(userPasswordChangeDTO);
    }


}
