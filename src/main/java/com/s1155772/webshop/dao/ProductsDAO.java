package com.s1155772.webshop.dao;

import com.s1155772.webshop.models.Products;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductsDAO {

    private ProductsRepository productsRepository;

    public ProductsDAO(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Products> getAllProducts(){
        List<Products> products = this.productsRepository.findAll();
        return products;
    }
}
