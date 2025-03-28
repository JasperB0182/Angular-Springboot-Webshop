package com.s1155772.webshop.controllers;

import com.s1155772.webshop.dao.UserDAO;
import com.s1155772.webshop.dao.UserRepository;
import com.s1155772.webshop.models.CustomUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    private UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //https://medium.com/@tericcabrel/implement-jwt-authentication-in-a-spring-boot-3-application-5839e4fd8fac
    @GetMapping("/me")
    public ResponseEntity<CustomUser> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentUser = (String) authentication.getPrincipal();

        CustomUser customUser = this.userDAO.findByEmail(currentUser);
        customUser.setPassword("-");

        System.out.println(customUser.getVoornaam() + ": " + currentUser + " is ingelogd.");

        return ResponseEntity.ok(customUser);
    }

}
