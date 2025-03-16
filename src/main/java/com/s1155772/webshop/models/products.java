package com.s1155772.webshop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class products {

    @Id
    @GeneratedValue
    private int product_id;

    private String product_naam;

    private int hoeveelheid;

    @ManyToOne
    @JoinColumn(name = "brand", nullable = false)
    @JsonIgnoreProperties("products")
    private brand brand;

    private String graphics_engine;

    private String videogeheugen;

    private int prijscategorie_id;

    private float prijs;

    private String img_product;

    @Column(length = 1000)
    private String beschrijving;

    public products(String product_naam, int hoeveelheid, brand brand, String graphics_engine, String videogeheugen, int prijscategorie_id, float prijs, String beschrijving, String img_product) {
        this.product_naam = product_naam;
        this.hoeveelheid = hoeveelheid;
        this.brand = brand;
        this.graphics_engine = graphics_engine;
        this.videogeheugen = videogeheugen;
        this.prijscategorie_id = prijscategorie_id;
        this.prijs = prijs;
        this.beschrijving = beschrijving;
        this.img_product = img_product;
    }

    public String getImg_product() {
        return img_product;
    }

    public void setImg_product(String img_product) {
        this.img_product = img_product;
    }

    public products() {

    }


    public String getProduct_naam() {
        return product_naam;
    }

    public void setProduct_naam(String product_naam) {
        this.product_naam = product_naam;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }

    public void setHoeveelheid(int hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }

    public brand getBrand() {
        return brand;
    }

    public void setBrand(brand brand) {
        this.brand = brand;
    }

    public String getGraphics_engine() {
        return graphics_engine;
    }

    public void setGraphics_engine(String graphics_engine) {
        this.graphics_engine = graphics_engine;
    }

    public String getVideogeheugen() {
        return videogeheugen;
    }

    public void setVideogeheugen(String videogeheugen) {
        this.videogeheugen = videogeheugen;
    }

    public int getPrijscategorie_id() {
        return prijscategorie_id;
    }

    public void setPrijscategorie_id(int prijscategorie_id) {
        this.prijscategorie_id = prijscategorie_id;
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

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
