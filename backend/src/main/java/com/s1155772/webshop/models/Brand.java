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
    private int brandId;

    private String brandName;

    private String imgLocation;

    @OneToMany(mappedBy = "brand")
    @JsonIgnoreProperties("brand")
    private List<Product> products;

    public Brand(String brandName, String imgLocation) {
        this.brandName = brandName;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String merk_naam) {
        this.brandName = merk_naam;
    }

    public String getImgLocation() {
        return imgLocation;
    }

    public void setImgLocation(String imgLocation) {
        this.imgLocation = imgLocation;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int merk_id) {
        this.brandId = merk_id;
    }
}
