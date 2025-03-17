package com.s1155772.webshop.dao;

import com.s1155772.webshop.models.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductsDAO {

    private ProductsRepository productsRepository;

    public ProductsDAO(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> getAllProducts(){
        List<Product> products = this.productsRepository.findAll();
        return products;
    }
}
