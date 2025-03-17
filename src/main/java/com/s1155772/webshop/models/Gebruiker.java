package com.s1155772.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

//Problemen? Check de constructor!!!

@Entity
public class Gebruiker {
    @Id
    @GeneratedValue
    private int gebruikerId;

    private String email;

    private String voornaam;

    private String achternaam;

    private String wachtwoord;

    private String adres;

    @ManyToOne
    @JoinColumn(name = "gebruikerRol", nullable = false)
    private GebruikerRol gebruikerRol;

    @OneToMany(mappedBy = "gebruiker")
    private List<Bestelling> bestellingen;

    public Gebruiker(GebruikerRol gebruikerRol, String adres, String wachtwoord, String achternaam, String voornaam, String email) {
        this.gebruikerRol = gebruikerRol;
        this.adres = adres;
        this.wachtwoord = wachtwoord;
        this.achternaam = achternaam;
        this.voornaam = voornaam;
        this.email = email;
    }

    public List<Bestelling> getBestellingen() {
        return bestellingen;
    }

    public void setBestellingen(List<Bestelling> bestellingen) {
        this.bestellingen = bestellingen;
    }

    public GebruikerRol getGebruikerRol() {
        return gebruikerRol;
    }

    public void setGebruikerRol(GebruikerRol gebruikerRol) {
        this.gebruikerRol = gebruikerRol;
    }

    public Gebruiker(){

    }

    public int getGebruikerId() {
        return gebruikerId;
    }

    public void setGebruikerId(int gebruikerId) {
        this.gebruikerId = gebruikerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    // role_id :))))
}
