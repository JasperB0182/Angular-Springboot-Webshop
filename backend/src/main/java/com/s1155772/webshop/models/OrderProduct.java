package com.s1155772.webshop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;



@Entity
public class OrderProduct {
    @Id
    @GeneratedValue
    private int productOrderNumber;

    private int amountBought;

    @ManyToOne
    @JsonBackReference("order-products")
    private Order orderId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public OrderProduct(int amountBought, Order orderId, Product product) {
        this.amountBought = amountBought;
        this.orderId = orderId;
        this.product = product;
    }

    public OrderProduct() {
    }

    public int getProductOrderNumber() {
        return productOrderNumber;
    }

    public void setProductOrderNumber(int productOrderNumber) {
        this.productOrderNumber = productOrderNumber;
    }

    public int getAmountBought() {
        return amountBought;
    }

    public void setAmountBought(int hoeveelheid_besteld) {
        this.amountBought = hoeveelheid_besteld;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
