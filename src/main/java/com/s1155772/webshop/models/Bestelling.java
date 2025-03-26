package com.s1155772.webshop.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

//Problemen? Check de constructor!!!
//TODO: boolean toevoegen of de bestelling afgehandeld is

@Entity
public class Bestelling {
    @Id
    @GeneratedValue
    private int bestellingId;

    private Date orderDatum;

    @ManyToOne
    @JoinColumn(name = "gebruikerId")
    private Gebruiker gebruiker;

    @OneToMany(mappedBy = "bestellingId")
    private List<BestellingProduct> bestellingProducten;

    public Bestelling(Date orderDatum, Gebruiker gebruiker) {
        this.orderDatum = orderDatum;
        this.gebruiker = gebruiker;
    }

    public Bestelling(){
    }

    public List<BestellingProduct> getBestellingProducten() {
        return bestellingProducten;
    }

    public void setBestellingProducten(List<BestellingProduct> bestellingProducten) {
        this.bestellingProducten = bestellingProducten;
    }

    public int getBestellingId() {
        return bestellingId;
    }

    public void setBestellingId(int bestellingId) {
        this.bestellingId = bestellingId;
    }

    public Date getOrderDatum() {
        return orderDatum;
    }

    public void setOrderDatum(Date orderDatum) {
        this.orderDatum = orderDatum;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }
}
