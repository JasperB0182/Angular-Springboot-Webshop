package com.s1155772.webshop.dto;

public class LoginResponse {
    public String email;
    public String token;
    public String voornaam;

    public LoginResponse(String email, String token, String voornaam) {
        this.email = email;
        this.token = token;
        this.voornaam = voornaam;
    }
}
