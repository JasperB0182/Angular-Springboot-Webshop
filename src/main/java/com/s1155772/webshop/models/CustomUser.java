package com.s1155772.webshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

// Het is misschien maar handiger als ik alle gegevens stuur van de ingelogde gebruiker.

@Entity(name = "custom_user")
public class CustomUser {

    @Id
    @GeneratedValue
    private long id;

    private String email;

    private String password;

    private String voornaam;

    // Gewoon niet in de constructor zetten dan!!
    @OneToMany(mappedBy = "gebruiker")
    private List<Bestelling> bestellingen;

    public CustomUser() {
    }

    public CustomUser(String email, String password, String voornaam) {
        this.email = email;
        this.password = password;
        this.voornaam = voornaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
