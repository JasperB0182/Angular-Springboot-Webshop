package com.s1155772.webshop.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

//Problemen? Check de constructor!!!
//TODO: boolean toevoegen of de bestelling afgehandeld is

@Entity
public class Bestelling {
    @Id
    @GeneratedValue
    private int bestellingId;

    private LocalDate orderDatum;

    @ManyToOne
    @JoinColumn(name = "gebruikerId")
    private CustomUser gebruiker;

    @OneToMany(mappedBy = "bestellingId", cascade = CascadeType.ALL)
    private List<BestellingProduct> bestellingProducten;

    public Bestelling(LocalDate orderDatum, CustomUser gebruiker) {
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

    public LocalDate getOrderDatum() {
        return orderDatum;
    }

    public void setOrderDatum(LocalDate orderDatum) {
        this.orderDatum = orderDatum;
    }

    public CustomUser getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(CustomUser gebruiker) {
        this.gebruiker = gebruiker;
    }
}
