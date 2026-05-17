package com.s1155772.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;



@Entity
public class Product {

    @Id
    @GeneratedValue
    private int productId;

    private String productName;

    private int amount;

    @ManyToOne
    @JoinColumn(name = "brand", nullable = false)
    @JsonIgnoreProperties("products")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category", nullable = false)
    @JsonIgnoreProperties("products")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProductList;

    private float price;

    private String imgProduct;

    private int amountInCart = 1;

    @Column(length = 1000)
    private String description;

    @Column(length = 1000)
    private String descriptionEN;

    public Product(String productName, int amount, Brand brand, Category category, float price, String description, String descriptionEN, String imgProduct) {
        this.productName = productName;
        this.amount = amount;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.descriptionEN = descriptionEN;
        this.imgProduct = imgProduct;
    }



    public String getDescriptionEN() {
        return descriptionEN;
    }

    public void setDescriptionEN(String descriptionEN) {
        this.descriptionEN = descriptionEN;
    }

    public int getAmountInCart() {
        return amountInCart;
    }

    public void setAmountInCart(int amountInCart) {
        this.amountInCart = amountInCart;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String img_product) {
        this.imgProduct = img_product;
    }

    public Product() {

    }

    public Category getcategory() {
        return category;
    }

    public void setcategory(Category category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String ProductName) {
        this.productName = ProductName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int Amount) {
        this.amount = Amount;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
