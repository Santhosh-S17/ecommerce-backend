package com.santhosh.ecommercebackend.Controller;


import com.santhosh.ecommercebackend.DTO.LoginDTO;
import com.santhosh.ecommercebackend.Entity.User;
import com.santhosh.ecommercebackend.Repository.UserRepository;
import com.santhosh.ecommercebackend.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword()
                )
        );

        User user = userRepository.findByEmail(dto.getEmail()).orElseThrow();

        return jwtUtil.generateToken(user.getEmail(), user.getRole());
    }
}
