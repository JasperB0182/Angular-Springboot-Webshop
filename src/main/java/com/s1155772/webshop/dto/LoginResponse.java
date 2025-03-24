package com.s1155772.webshop.dto;

public class LoginResponse {
    public String email;
    public String token;
    public long id;
    public String voornaam;

    public LoginResponse(String email, String token, long id, String voornaam) {
        this.email = email;
        this.token = token;
        this.id = id;
        this.voornaam = voornaam;
    }
}
