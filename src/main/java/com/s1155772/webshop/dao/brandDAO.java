package com.s1155772.webshop.dao;

import com.s1155772.webshop.models.brand;
import com.s1155772.webshop.models.products;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class brandDAO {

    private brandRepository brandRepository;

    public brandDAO(com.s1155772.webshop.dao.brandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<brand> getAllBrands(){
        List<brand> brands = this.brandRepository.findAll();
        return brands;
    }
}
