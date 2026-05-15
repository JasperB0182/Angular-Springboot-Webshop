package com.s1155772.webshop.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

public class AuthenticationDTO {
    public String email;
    public String password;

    @Size(max=15)
    public String voornaam;

    public AuthenticationDTO(String email, String password, String voornaam) {
        this.email = email;
        this.password = password;
        this.voornaam = voornaam;
    }
}
