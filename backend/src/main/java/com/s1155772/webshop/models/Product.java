package com.s1155772.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;



@Entity
public class Product {

    @Id
    @GeneratedValue
    private int productId;

    private String productNaam;

    private int hoeveelheid;

    @ManyToOne
    @JoinColumn(name = "brand", nullable = false)
    @JsonIgnoreProperties("products")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "categorie", nullable = false)
    @JsonIgnoreProperties("products")
    private Categorie categorie;

    @OneToMany(mappedBy = "product")
    private List<BestellingProduct> bestellingProducten;

    private float prijs;

    private String imgProduct;

    private int aantalInWinkelwagen = 1;

    @Column(length = 1000)
    private String beschrijving;

    @Column(length = 1000)
    private String beschrijvingEN;

    public Product(String productNaam, int hoeveelheid, Brand brand, Categorie categorie, float prijs, String beschrijving, String beschrijvingEN, String imgProduct) {
        this.productNaam = productNaam;
        this.hoeveelheid = hoeveelheid;
        this.categorie = categorie;
        this.brand = brand;
        this.prijs = prijs;
        this.beschrijving = beschrijving;
        this.beschrijvingEN = beschrijvingEN;
        this.imgProduct = imgProduct;
    }



    public String getBeschrijvingEN() {
        return beschrijvingEN;
    }

    public void setBeschrijvingEN(String beschrijvingEN) {
        this.beschrijvingEN = beschrijvingEN;
    }

    public int getAantalInWinkelwagen() {
        return aantalInWinkelwagen;
    }

    public void setAantalInWinkelwagen(int aantalInWinkelwagen) {
        this.aantalInWinkelwagen = aantalInWinkelwagen;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String img_product) {
        this.imgProduct = img_product;
    }

    public Product() {

    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getProductNaam() {
        return productNaam;
    }

    public void setProductNaam(String productNaam) {
        this.productNaam = productNaam;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }

    public void setHoeveelheid(int hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public float getPrijs() {
        return prijs;
    }

    public void setPrijs(float prijs) {
        this.prijs = prijs;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
