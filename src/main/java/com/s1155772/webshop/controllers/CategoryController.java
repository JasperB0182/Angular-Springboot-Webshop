package com.s1155772.webshop.controllers;

import com.s1155772.webshop.dao.CategoryDAO;
import com.s1155772.webshop.models.Categorie;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryDAO categoryDAO;

    public CategoryController(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @GetMapping
    public List<Categorie> getAllCategories(){
        return this.categoryDAO.getAllCategories();
    }
}
