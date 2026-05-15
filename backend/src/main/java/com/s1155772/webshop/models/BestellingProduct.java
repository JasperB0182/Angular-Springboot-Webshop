package com.s1155772.webshop.models;

import jakarta.persistence.*;



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

    public int getProductBestellingNummer() {
        return ProductBestellingNummer;
    }

    public void setProductBestellingNummer(int productBestellingNummer) {
        ProductBestellingNummer = productBestellingNummer;
    }

    public int getHoeveelheid_besteld() {
        return hoeveelheid_besteld;
    }

    public void setHoeveelheid_besteld(int hoeveelheid_besteld) {
        this.hoeveelheid_besteld = hoeveelheid_besteld;
    }

    public Bestelling getBestellingId() {
        return bestellingId;
    }

    public void setBestellingId(Bestelling bestellingId) {
        this.bestellingId = bestellingId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
