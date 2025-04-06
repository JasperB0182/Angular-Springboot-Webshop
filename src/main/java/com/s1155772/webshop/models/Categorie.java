package com.s1155772.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Categorie {

    @Id
    @GeneratedValue
    private int categoryId;

    private String categoryName;

    @OneToMany(mappedBy = "categorie")
    @JsonIgnoreProperties("category")
    private List<Product> products;

    public Categorie(String categoryName) {
        this.categoryName = categoryName;
    }

    public Categorie(){

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
