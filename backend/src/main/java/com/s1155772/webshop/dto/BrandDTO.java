package com.s1155772.webshop.dto;

public class BrandDTO {
    private Long brandId;
    private String brandName;
    private String imgLocation;

    public BrandDTO(Long brandId, String brandName, String imgLocation) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.imgLocation = imgLocation;
    }
}
