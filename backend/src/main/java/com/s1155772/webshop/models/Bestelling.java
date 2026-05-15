package com.s1155772.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;



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
    @JsonIgnoreProperties("bestellingId")
    private List<BestellingProduct> bestellingProducten;

    private String Address;

    private String fullname;

    private String city;

    private String postcode;

    private float totaleprijs;

    public Bestelling(LocalDate orderDatum, CustomUser gebruiker, String address, String fullname, String city, String postcode, Float totaleprijs) {
        this.orderDatum = orderDatum;
        this.gebruiker = gebruiker;
        Address = address;
        this.fullname = fullname;
        this.city = city;
        this.postcode = postcode;
        this.totaleprijs = totaleprijs;
    }



    public float getTotaleprijs() {
        return totaleprijs;
    }

    public void setTotaleprijs(float totaleprijs) {
        this.totaleprijs = totaleprijs;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Bestelling(){
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
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
