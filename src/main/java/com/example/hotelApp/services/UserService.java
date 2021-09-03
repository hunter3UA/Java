package com.example.hotelApp.services;

import com.example.hotelApp.dto.UserCreateDTO;
import com.example.hotelApp.dto.UserDTO;
import com.example.hotelApp.dto.UserPasswordChangeDTO;
import com.example.hotelApp.mapper.AutoMapper;
import com.example.hotelApp.models.ShoppingCart;
import com.example.hotelApp.models.User;
import com.example.hotelApp.repository.CartRepository;
import com.example.hotelApp.repository.UserRepository;
import com.example.hotelApp.sl.Security;
import javassist.bytecode.ByteArray;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ICartService cartService;

    @Override
    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        User newUser=new User();
        newUser.setId(0);
        newUser.setEmail(userCreateDTO.getEmail());
        newUser.setName(userCreateDTO.getName());
        Security.Salted_Hash salted_hash=Security.getSaltedHash(userCreateDTO.getPassword());
        newUser.setPassword_hash(salted_hash.passwordHash);
        newUser.setHash_iterations(salted_hash.hash_iterations);
        newUser.setIs_deleted(false);
        try{
            newUser = userRepository.save(newUser);
        }catch (Exception ex){

        }

        return AutoMapper.mapUser(newUser);
    }

    @Override
    public List<UserDTO> allUsers() {
        List<User> allUsers= (List<User>) userRepository.findAll();
        return AutoMapper.mapListOfUsers(allUsers);
    }

    @Override
    public UserDTO byID(Integer userID) {
        if(userRepository.existsById(userID)){
            User userById=userRepository.findById(userID).get();
            return AutoMapper.mapUser(userById);
        }
        return new UserDTO();

    }

    @Override
    public Boolean deleteByID(Integer userID) {
        if(userRepository.existsById(userID)){
            User userToDelete=userRepository.findById(userID).get();
            userToDelete.setIs_deleted(true);
            userRepository.save(userToDelete);
            cartService.deleteByUserID(userID);
            return true;
        }
        return false;

    }

    @Override
    public UserDTO updateUser(UserDTO userUpdateDTO) {
        if(userRepository.existsById(userUpdateDTO.getId())){
            User userToUpdate=userRepository.findById(userUpdateDTO.getId()).get();
            if(!userToUpdate.getIs_deleted()){
                userToUpdate.setName(userUpdateDTO.getName());
                userToUpdate.setEmail(userUpdateDTO.getEmail());
                userRepository.save(userToUpdate);
                return AutoMapper.mapUser(userToUpdate);
            }
        }
        return new UserDTO();
    }

    @Override
    public Boolean updatePassword(UserPasswordChangeDTO userPasswordChangeDTO) {
        if(userRepository.existsById(userPasswordChangeDTO.getUserID())){
            User userToUpdate= userRepository.findById(userPasswordChangeDTO.getUserID()).get();
            if(!userToUpdate.getIs_deleted()){
                Security.Salted_Hash salted_hash=Security.getSaltedHash(userPasswordChangeDTO.getNewPassword());
                userToUpdate.setHash_iterations(salted_hash.hash_iterations);
                userToUpdate.setPassword_hash(salted_hash.passwordHash);
                userRepository.save(userToUpdate);
                return true;
            }
        }
        return false;
    }
}
