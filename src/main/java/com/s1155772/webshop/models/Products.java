package com.s1155772.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Products {

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
    @JoinColumn(name = "category", nullable = false)
    @JsonIgnoreProperties("products")
    private Category category;

    private float prijs;

    private String imgProduct;

    @Column(length = 1000)
    private String beschrijving;

    public Products(String productNaam, int hoeveelheid, Brand brand, Category Category, float prijs, String beschrijving, String imgProduct) {
        this.productNaam = productNaam;
        this.hoeveelheid = hoeveelheid;
        this.category = Category;
        this.brand = brand;
        this.prijs = prijs;
        this.beschrijving = beschrijving;
        this.imgProduct = imgProduct;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String img_product) {
        this.imgProduct = img_product;
    }

    public Products() {

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categorie) {
        this.category = categorie;
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
