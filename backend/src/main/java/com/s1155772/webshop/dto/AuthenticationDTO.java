package com.s1155772.webshop.dto;

import jakarta.validation.constraints.Size;

public class AuthenticationDTO {
    public String email;
    public String password;

    @Size(max=15)
    public String firstName;

    public AuthenticationDTO(String email, String password, String firstName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
    }
}
