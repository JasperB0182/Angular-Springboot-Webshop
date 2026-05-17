package com.s1155772.webshop.dao;

import com.s1155772.webshop.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findBycategoryName(String categoryName);
}
