package com.s1155772.webshop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customer_order")
public class Order {
    @Id
    @GeneratedValue
    private int orderId;

    private LocalDate orderDate;

    @ManyToOne
    @JsonBackReference("user-order")
    private CustomUser user;

    @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL)
    @JsonManagedReference("order-products")
    private List<OrderProduct> orderProducts;

    private String address;

    private String fullname;

    private String city;

    private String zipcode;

    private float totalPrice;

    public Order(LocalDate orderDate, CustomUser user, String address, String fullname, String city, String zipcode, Float totalPrice) {
        this.orderDate = orderDate;
        this.user = user;
        this.address = address;
        this.fullname = fullname;
        this.city = city;
        this.zipcode = zipcode;
        this.totalPrice = totalPrice;
    }



    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Order(){
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public CustomUser getUser() {
        return user;
    }

    public void setUser(CustomUser user) {
        this.user = user;
    }
}
