package com.s1155772.webshop.dto;

public class LoginResponse {
    public String email;
    public String token;
    public String firstName;

    public LoginResponse(String email, String token, String firstName) {
        this.email = email;
        this.token = token;
        this.firstName = firstName;
    }
}
