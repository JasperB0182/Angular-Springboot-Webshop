package com.s1155772.webshop.dao;

import com.s1155772.webshop.models.Categorie;
import com.s1155772.webshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategorie(Categorie categorie);

    Product findByProductNaam(String productNaam);
}
