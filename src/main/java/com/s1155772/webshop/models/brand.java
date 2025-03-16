package com.s1155772.webshop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Entity
public class brand {
    @Id
    @GeneratedValue
    private int merk_id;

    private String merk_naam;

    private String img_location;

    @OneToMany(mappedBy = "brand")
    @JsonIgnoreProperties("brand")
    private List<products> products;

    public brand(String merk_naam, String img_location) {
        this.merk_naam = merk_naam;
        this.img_location = img_location;
    }

    public brand() {

    }

    public List<products> getProducts() {
        return products;
    }

    public void setProducts(List<products> products) {
        this.products = products;
    }

    public String getMerk_naam() {
        return merk_naam;
    }

    public void setMerk_naam(String merk_naam) {
        this.merk_naam = merk_naam;
    }

    public String getImg_location() {
        return img_location;
    }

    public void setImg_location(String img_location) {
        this.img_location = img_location;
    }

    public int getMerk_id() {
        return merk_id;
    }

    public void setMerk_id(int merk_id) {
        this.merk_id = merk_id;
    }
}
