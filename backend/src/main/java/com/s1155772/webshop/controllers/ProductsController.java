package com.s1155772.webshop.controllers;


import com.s1155772.webshop.dao.ProductDAO;
import com.s1155772.webshop.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductsController {

    private ProductDAO ProductDAO;

    public ProductsController(ProductDAO productDAO) {
        this.ProductDAO = productDAO;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return this.ProductDAO.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return this.ProductDAO.getProductById(id);
    }

    @GetMapping("/category/{categoryName}")
    public List<Product> getProductsByCategory(@PathVariable String categoryName){
        return this.ProductDAO.getProductsByCategory(categoryName);
    }

    @GetMapping("/search/{name}")
    public List<Product> getProductByName(@PathVariable String name){
        return this.ProductDAO.getProductByName(name);
    }



}
