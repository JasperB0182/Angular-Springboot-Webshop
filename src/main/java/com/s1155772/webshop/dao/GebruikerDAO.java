package com.s1155772.webshop.dao;

import org.springframework.stereotype.Component;

@Component
public class GebruikerDAO {

    private GebruikerRepository gebruikerRepository;

    public GebruikerDAO(GebruikerRepository gebruikerRepository) {
        this.gebruikerRepository = gebruikerRepository;
    }
}
