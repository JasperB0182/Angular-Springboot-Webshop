package com.s1155772.webshop.dto;

public class ProductDTO {
    private Long productId;
    private String productName;
    private String description;
    private double price;
    private int amountInCart;
    private int amount;
    private String imgProduct;

    private BrandDTO brand;
    private CategoryDTO category;

    public ProductDTO(Long productId, String productName, String description, double price, int amountInCart, int amount, String imgProduct, BrandDTO brand, CategoryDTO category) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.amountInCart = amountInCart;
        this.amount = amount;
        this.imgProduct = imgProduct;
        this.brand = brand;
        this.category = category;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmountInCart() {
        return amountInCart;
    }

    public void setAmountInCart(int amountInCart) {
        this.amountInCart = amountInCart;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String imgProduct) {
        this.imgProduct = imgProduct;
    }

    public BrandDTO getBrand() {
        return brand;
    }

    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
