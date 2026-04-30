package com.santhosh.ecommercebackend.Controller;

import com.santhosh.ecommercebackend.DTO.UserDTO;
import com.santhosh.ecommercebackend.DTO.UserResponseDTO;
import com.santhosh.ecommercebackend.Entity.User;
import com.santhosh.ecommercebackend.Repository.UserRepository;
import com.santhosh.ecommercebackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;



    //Register
    @PostMapping("/register")
    public UserResponseDTO register(@RequestBody UserDTO dto){

        return userService.register(dto);
    }

    @GetMapping("/email/{email}")
    public UserResponseDTO getByEmail(@PathVariable String email){
        return userService.getByEmail(email);
    }
     @GetMapping("/{id}")
    public UserResponseDTO getById(@PathVariable Long id){
        return userService.getById(id);
     }

}
