package com.s1155772.webshop.dto;

public class CategorieDTO {
    private Long categoryId;
    private String categoryName;

    public CategorieDTO(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
}
