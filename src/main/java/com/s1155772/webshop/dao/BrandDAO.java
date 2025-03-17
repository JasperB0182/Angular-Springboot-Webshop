package com.s1155772.webshop.dao;

import com.s1155772.webshop.models.Brand;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandDAO {

    private BrandRepository brandRepository;

    public BrandDAO(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAllBrands(){
        List<Brand> Brands = this.brandRepository.findAll();
        return Brands;
    }
}
