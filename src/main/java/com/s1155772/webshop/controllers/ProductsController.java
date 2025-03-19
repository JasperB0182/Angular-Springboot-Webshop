package com.s1155772.webshop.controllers;


import com.s1155772.webshop.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductsController {

    private com.s1155772.webshop.dao.ProductsDAO ProductsDAO;

    public ProductsController(com.s1155772.webshop.dao.ProductsDAO productsDAO) {
        this.ProductsDAO = productsDAO;
    }

    @GetMapping
    public List<Product> getAllproducts(){
        return this.ProductsDAO.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return this.ProductsDAO.getProductById(id);
    }

    @GetMapping("/category/{categoryName}")
    public List<Product> getProductsByCategory(@PathVariable String categoryName){
        return this.ProductsDAO.getProductsByCategory(categoryName);
    }


}
