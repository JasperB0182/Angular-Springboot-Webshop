package com.s1155772.webshop.models;

import jakarta.persistence.*;

//Problemen? Check de constructor!!!

@Entity
public class BestellingProduct {
    @Id
    @GeneratedValue
    private int ProductBestellingNummer;

    private int hoeveelheid_besteld;

    @ManyToOne
    @JoinColumn(name = "bestellingId")
    private Bestelling bestellingId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public BestellingProduct(int hoeveelheid_besteld, Bestelling bestellingId, Product product) {
        this.hoeveelheid_besteld = hoeveelheid_besteld;
        this.bestellingId = bestellingId;
        this.product = product;
    }

    public BestellingProduct() {
    }
}
