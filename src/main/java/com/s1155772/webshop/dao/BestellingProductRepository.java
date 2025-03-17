package com.s1155772.webshop.dao;

import com.s1155772.webshop.models.BestellingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestellingProductRepository extends JpaRepository<BestellingProduct, Long> {
}
