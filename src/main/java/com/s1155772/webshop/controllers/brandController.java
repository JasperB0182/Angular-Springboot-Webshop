package com.s1155772.webshop.controllers;

import com.s1155772.webshop.dao.brandDAO;
import com.s1155772.webshop.dao.productsDAO;
import com.s1155772.webshop.models.brand;
import com.s1155772.webshop.models.products;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/brands")
public class brandController {

    private brandDAO brandDAO;

    public brandController(com.s1155772.webshop.dao.brandDAO brandDAO) {
        this.brandDAO = brandDAO;
    }

    @GetMapping
    public List<brand> getAllBrands(){
        return this.brandDAO.getAllBrands();
    }

}
