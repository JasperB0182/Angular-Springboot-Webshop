package com.s1155772.webshop.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;



@Entity(name = "custom_user")
public class CustomUser {

    @Id
    @GeneratedValue
    private long id;

    private String email;

    private String password;

    private String firstName;


    @OneToMany(mappedBy = "user")
    @JsonManagedReference("user-order")
    private List<Order> orderList;

    public CustomUser() {
    }

    public CustomUser(String email, String password, String firstName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orders) {
        this.orderList = orders;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String voornaam) {
        this.firstName = voornaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
