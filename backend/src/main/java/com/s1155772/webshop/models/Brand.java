package com.s1155772.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;



@Entity
public class Brand {
    @Id
    @GeneratedValue
    private int merkId;

    private String merkNaam;

    private String imgLocation;

    @OneToMany(mappedBy = "brand")
    @JsonIgnoreProperties("brand")
    private List<Product> products;

    public Brand(String MerkNaam, String imgLocation) {
        this.merkNaam = MerkNaam;
        this.imgLocation = imgLocation;
    }

    public Brand() {

    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getMerkNaam() {
        return merkNaam;
    }

    public void setMerkNaam(String merk_naam) {
        this.merkNaam = merk_naam;
    }

    public String getImgLocation() {
        return imgLocation;
    }

    public void setImgLocation(String imgLocation) {
        this.imgLocation = imgLocation;
    }

    public int getMerkId() {
        return merkId;
    }

    public void setMerkId(int merk_id) {
        this.merkId = merk_id;
    }
}
