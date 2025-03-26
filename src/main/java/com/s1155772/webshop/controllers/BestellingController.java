package com.s1155772.webshop.controllers;


import com.s1155772.webshop.dao.BestellingDAO;
import com.s1155772.webshop.models.Bestelling;
import com.s1155772.webshop.models.Brand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bestelling")
public class BestellingController {

    private BestellingDAO bestellingDAO;

    public BestellingController(BestellingDAO bestellingDAO) {
        this.bestellingDAO = bestellingDAO;
    }

    @GetMapping
    public List<Bestelling> getAllBestellingen(){
        return this.bestellingDAO.getAllBestellingen();
    }
}
