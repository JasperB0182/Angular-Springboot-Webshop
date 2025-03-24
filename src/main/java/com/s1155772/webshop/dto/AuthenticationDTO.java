package com.s1155772.webshop.dto;

public class AuthenticationDTO {
    public String email;
    public String password;

    public AuthenticationDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
