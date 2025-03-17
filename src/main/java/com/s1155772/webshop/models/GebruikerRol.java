package com.s1155772.webshop.models;

import jakarta.persistence.*;

import java.util.List;

//Problemen? Check de constructor!!!

@Entity
public class GebruikerRol {
    @Id
    @GeneratedValue
    private int rolId;

    private String rolNaam;

    @OneToMany(mappedBy = "gebruikerRol")
    private List<Gebruiker> gebruikers;

    public GebruikerRol(String rolNaam) {
        this.rolNaam = rolNaam;
    }

    public GebruikerRol() {
    }

    public String getRolNaam() {
        return rolNaam;
    }

    public void setRolNaam(String rolNaam) {
        this.rolNaam = rolNaam;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }
}
