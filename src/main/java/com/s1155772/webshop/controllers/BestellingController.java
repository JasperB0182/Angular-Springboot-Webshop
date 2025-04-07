package com.s1155772.webshop.controllers;


import com.s1155772.webshop.dao.BestellingDAO;
import com.s1155772.webshop.dao.ProductDAO;
import com.s1155772.webshop.dao.UserDAO;
import com.s1155772.webshop.dto.BestellingDTO;
import com.s1155772.webshop.models.*;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bestelling")
public class BestellingController {

    private BestellingDAO bestellingDAO;

    private UserDAO userDAO;

    private ProductDAO productDAO;




    public BestellingController(BestellingDAO bestellingDAO, ProductDAO productDAO, UserDAO userDAO) {
        this.bestellingDAO = bestellingDAO;
        this.productDAO = productDAO;
        this.userDAO = userDAO;
    }


    @PostMapping("/plaats")
    public void setNewBestelling(@Valid @RequestBody BestellingDTO bestellingDTO){
        List<Product> productList = bestellingDTO.getProducts();

        String address = bestellingDTO.getAddress();

        String fullName = bestellingDTO.getFullname();

        String city = bestellingDTO.getCity();

        String postcode = bestellingDTO.getPostcode();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentUser = (String) authentication.getPrincipal();

        CustomUser customUser = this.userDAO.findByEmail(currentUser);

        Bestelling bestelling = new Bestelling(LocalDate.now(), customUser, address, fullName, city, postcode, (float) 0);

        List<BestellingProduct> bestellingProductList = new ArrayList<>();

        float totalePrijs = 0;

        for (Product product : productList){
            if (product.getAantalInWinkelwagen() <= 0 ){
                product.setAantalInWinkelwagen(0);
            }
            Product originalProduct = this.productDAO.findByProductId((long) product.getProductId());
            float prijs = (originalProduct.getPrijs() * product.getAantalInWinkelwagen());
            totalePrijs += prijs;
            Long productId = (long) product.getProductId();
            int aantalInWinkelwagen = product.getAantalInWinkelwagen();
            if (aantalInWinkelwagen > 100000){
                aantalInWinkelwagen = 99999;
            }
            Product Product = this.productDAO.findByProductId(productId);
            BestellingProduct bestellingProduct = new BestellingProduct(aantalInWinkelwagen, bestelling, Product);
            bestellingProductList.add(bestellingProduct);

        }
        bestelling.setTotaleprijs(totalePrijs);

        bestelling.setBestellingProducten(bestellingProductList);

        this.bestellingDAO.saveToDatabase(bestelling);





    }
}
