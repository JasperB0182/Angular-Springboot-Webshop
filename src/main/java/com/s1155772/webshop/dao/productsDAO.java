package com.s1155772.webshop.dao;

import com.s1155772.webshop.models.products;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class productsDAO {

    private productsRepository productsRepository;

    public productsDAO(com.s1155772.webshop.dao.productsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<products> getAllProducts(){
        List<products> products = this.productsRepository.findAll();
        return products;
    }
}
