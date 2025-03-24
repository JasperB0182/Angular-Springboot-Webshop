package com.s1155772.webshop.dto;

public class LoginResponse {
    public String email;
    public String token;
    public long id;

    public LoginResponse(String email, String token, int id) {
        this.email = email;
        this.token = token;
        this.id = id;
    }
}
