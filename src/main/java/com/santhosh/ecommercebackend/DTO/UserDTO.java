package com.santhosh.ecommercebackend.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {

    private String name;
    @Email
    private String email;
    @NotNull
    private String password;
    private String role;
}
