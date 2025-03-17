package com.s1155772.webshop.controllers;

import com.s1155772.webshop.dao.BrandDAO;
import com.s1155772.webshop.models.Brand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/brands")
public class BrandController {

    private BrandDAO brandDAO;

    public BrandController(BrandDAO brandDAO) {
        this.brandDAO = brandDAO;
    }

    @GetMapping
    public List<Brand> getAllBrands(){
        return this.brandDAO.getAllBrands();
    }

}
