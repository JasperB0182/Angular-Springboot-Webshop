package com.s1155772.webshop.dto;

public class BrandDTO {
    private Long merkId;
    private String merkNaam;
    private String imgLocation;

    public BrandDTO(Long merkId, String merkNaam, String imgLocation) {
        this.merkId = merkId;
        this.merkNaam = merkNaam;
        this.imgLocation = imgLocation;
    }
}
