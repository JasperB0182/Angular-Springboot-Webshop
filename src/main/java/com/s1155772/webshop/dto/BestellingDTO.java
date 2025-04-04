package com.s1155772.webshop.dto;

import com.s1155772.webshop.models.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class BestellingDTO {

    @NotNull
    private List<Product> products;

    @Size(min=3, max=40)
    private String address;

    @Size(min=3, max=35)
    private String fullname;

    @Size(min = 3, max = 20)
    private String city;

    @Size(min=6, max=6)
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
