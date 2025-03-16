package com.s1155772.webshop.controllers;


import com.s1155772.webshop.dao.productsDAO;
import com.s1155772.webshop.models.products;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class productsController {

    private productsDAO ProductsDAO;

    public productsController(com.s1155772.webshop.dao.productsDAO productsDAO) {
        this.ProductsDAO = productsDAO;
    }

    @GetMapping
    public List<products> getAllproducts(){
        return this.ProductsDAO.getAllProducts();
    }


}
