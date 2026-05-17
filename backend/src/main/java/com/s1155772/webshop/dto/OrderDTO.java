package com.s1155772.webshop.dto;

import com.s1155772.webshop.models.Product;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class OrderDTO {

    @NotNull
    private List<Product> products;

    @Size(min=3, max=40)
    private String address;

    @Size(min=3, max=35)
    private String fullname;

    @Size(min = 3, max = 20)
    private String city;

    @Size(min=6, max=6)
    private String zipcode;

    public OrderDTO(List<Product> products, String address, String fullname, String city, String zipcode) {
        this.products = products;
        this.address = address;
        this.fullname = fullname;
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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
