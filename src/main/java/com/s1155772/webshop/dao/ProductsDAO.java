package com.s1155772.webshop.dao;

import com.s1155772.webshop.models.Categorie;
import com.s1155772.webshop.models.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductsDAO {

    private ProductsRepository productsRepository;

    private CategoryRepository categoryRepository;

    public ProductsDAO(ProductsRepository productsRepository, CategoryRepository categoryRepository) {
        this.productsRepository = productsRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAllProducts(){
        List<Product> products = this.productsRepository.findAll();
        return products;
    }

    public List<Product> getProductsByCategory(String categoryName) {
        Categorie categorie = this.categoryRepository.findBycategoryName(categoryName);
        return this.productsRepository.findByCategorie(categorie);
    }


    public Optional<Product> getProductById(Long productId) {
        return this.productsRepository.findById(productId);
    }

    public Product findByProductId(Long productId) {
        return this.productsRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product met dit ID niet gevonden: " + productId));
    }
}
