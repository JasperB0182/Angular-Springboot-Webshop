package com.s1155772.webshop.dto;

public class ProductDTO {
    private Long productId;
    private String productNaam;
    private String beschrijving;
    private double prijs;
    private int aantalInWinkelwagen;
    private int hoeveelheid;
    private String imgProduct;

    private BrandDTO brand;
    private CategorieDTO categorie;

    public ProductDTO(Long productId, String productNaam, String beschrijving, double prijs, int aantalInWinkelwagen, int hoeveelheid, String imgProduct, BrandDTO brand, CategorieDTO categorie) {
        this.productId = productId;
        this.productNaam = productNaam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        this.aantalInWinkelwagen = aantalInWinkelwagen;
        this.hoeveelheid = hoeveelheid;
        this.imgProduct = imgProduct;
        this.brand = brand;
        this.categorie = categorie;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductNaam() {
        return productNaam;
    }

    public void setProductNaam(String productNaam) {
        this.productNaam = productNaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public int getAantalInWinkelwagen() {
        return aantalInWinkelwagen;
    }

    public void setAantalInWinkelwagen(int aantalInWinkelwagen) {
        this.aantalInWinkelwagen = aantalInWinkelwagen;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }

    public void setHoeveelheid(int hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
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

    public CategorieDTO getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieDTO categorie) {
        this.categorie = categorie;
    }
}
