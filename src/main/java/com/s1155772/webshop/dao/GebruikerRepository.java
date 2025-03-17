package com.s1155772.webshop.dao;

import com.s1155772.webshop.models.Gebruiker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GebruikerRepository extends JpaRepository<Gebruiker, Long> {
}
