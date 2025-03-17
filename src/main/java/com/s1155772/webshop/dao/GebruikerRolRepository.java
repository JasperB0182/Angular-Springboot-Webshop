package com.s1155772.webshop.dao;

import com.s1155772.webshop.models.GebruikerRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GebruikerRolRepository extends JpaRepository<GebruikerRol, Long> {
}
