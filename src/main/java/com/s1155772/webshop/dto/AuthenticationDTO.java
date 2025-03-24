package com.s1155772.webshop.dto;

public class AuthenticationDTO {
    public String email;
    public String password;
    public String voornaam;

    public AuthenticationDTO(String email, String password, String voornaam) {
        this.email = email;
        this.password = password;
        this.voornaam = voornaam;
    }
}
