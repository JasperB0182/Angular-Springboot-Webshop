package com.s1155772.webshop.dao;

import com.s1155772.webshop.models.Bestelling;
import com.s1155772.webshop.models.Brand;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BestellingDAO {

    private BestellingRepository bestellingRepository;

    public BestellingDAO(BestellingRepository bestellingRepository) {
        this.bestellingRepository = bestellingRepository;
    }


    public List<Bestelling> getAllBestellingen() {
        List<Bestelling> Bestellingen = this.bestellingRepository.findAll();
        return Bestellingen;
    }
}
