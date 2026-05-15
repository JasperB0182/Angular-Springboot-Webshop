package com.s1155772.webshop.dao;import com.s1155772.webshop.models.Categorie;
import com.s1155772.webshop.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAO {

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    public ProductDAO(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAllProducts(){
        List<Product> products = this.productRepository.findAll();
        return products;
    }

    public List<Product> getProductsByCategory(String categoryName) {
        Categorie categorie = this.categoryRepository.findBycategoryName(categoryName);
        return this.productRepository.findByCategorie(categorie);
    }


    public Optional<Product> getProductById(Long productId) {
        return this.productRepository.findById(productId);
    }

    public Product findByProductId(Long productId) {
        return this.productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product met dit ID niet gevonden: " + productId));
    }

    public List<Product> getProductByName(String name) {
        List<Product> products = this.productRepository.findAll();
        List<Product> Searchproduct = new ArrayList<>();
        for (Product product : products){
            if (product.getProductNaam().toLowerCase().contains(name.toLowerCase())){
                Searchproduct.add(product);
            }
        }
        return Searchproduct;
    }
}
