package com.s1155772.webshop.dto;

import com.s1155772.webshop.models.Product;

import java.util.List;

public class BestellingDTO {

    private List<Product> products;

    private String address;

    private String fullname;

    private String city;

    private String postcode;

    public BestellingDTO(List<Product> products, String address, String fullname, String city, String postcode) {
        this.products = products;
        this.address = address;
        this.fullname = fullname;
        this.city = city;
        this.postcode = postcode;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullName(String fullName) {
        this.fullname = fullName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
