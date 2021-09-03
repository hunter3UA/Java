package com.example.hotelApp.services;

import com.example.hotelApp.dto.UserCreateDTO;
import com.example.hotelApp.dto.UserDTO;
import com.example.hotelApp.dto.UserPasswordChangeDTO;
import com.example.hotelApp.models.User;

import java.util.List;

public interface IUserService {
    public UserDTO createUser(UserCreateDTO userCreateDTO);
    public List<UserDTO> allUsers();
    public UserDTO byID(Integer userID);
    public Boolean deleteByID(Integer userID);
    public UserDTO updateUser(UserDTO userUpdateDTO);
    public Boolean updatePassword(UserPasswordChangeDTO userPasswordChangeDTO);

}
