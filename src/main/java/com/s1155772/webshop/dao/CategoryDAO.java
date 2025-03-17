package com.s1155772.webshop.dao;

import com.s1155772.webshop.models.Brand;
import com.s1155772.webshop.models.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDAO {

    private CategoryRepository categoryRepository;

    public CategoryDAO(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        List<Category> Categories = this.categoryRepository.findAll();
        return Categories;
    }
}
