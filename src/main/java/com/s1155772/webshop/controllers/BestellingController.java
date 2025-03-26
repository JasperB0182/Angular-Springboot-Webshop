package com.s1155772.webshop.controllers;


import com.s1155772.webshop.dao.BestellingDAO;
import com.s1155772.webshop.dao.ProductsDAO;
import com.s1155772.webshop.dao.UserDAO;
import com.s1155772.webshop.dto.ProductDTO;
import com.s1155772.webshop.models.Bestelling;
import com.s1155772.webshop.models.BestellingProduct;
import com.s1155772.webshop.models.CustomUser;
import com.s1155772.webshop.models.Product;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bestelling")
public class BestellingController {

    private BestellingDAO bestellingDAO;

    private UserDAO userDAO;

    private ProductsDAO productsDAO;

    public BestellingController(BestellingDAO bestellingDAO, ProductsDAO productsDAO, UserDAO userDAO) {
        this.bestellingDAO = bestellingDAO;
        this.productsDAO = productsDAO;
        this.userDAO = userDAO;
    }

    @GetMapping
    public List<Bestelling> getAllBestellingen(){
        return this.bestellingDAO.getAllBestellingen();
    }

    @PostMapping("/plaats")
    public void setNewBestelling(@RequestBody List<ProductDTO> productListDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentUser = (String) authentication.getPrincipal();

        System.out.println(currentUser);

        CustomUser customUser = this.userDAO.findByEmail(currentUser);

        Bestelling bestelling = new Bestelling(LocalDate.now(), customUser);

        List<BestellingProduct> bestellingProductList = new ArrayList<>();

        for (ProductDTO product : productListDTO){
            Long productId = product.getProductId();
            int aantalInWinkelwagen = product.getAantalInWinkelwagen();
            System.out.println(aantalInWinkelwagen);
            Product Product = this.productsDAO.findByProductId(productId);
            BestellingProduct bestellingProduct = new BestellingProduct(aantalInWinkelwagen, bestelling, Product);
            bestellingProductList.add(bestellingProduct);

        }
        bestelling.setBestellingProducten(bestellingProductList);

        this.bestellingDAO.saveToDatabase(bestelling);
    }
}
