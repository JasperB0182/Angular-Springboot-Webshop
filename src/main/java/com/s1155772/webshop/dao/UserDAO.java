package com.s1155772.webshop.dao;

import com.s1155772.webshop.models.CustomUser;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

    private UserRepository userRepository;

    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CustomUser findByEmail(String email){
        return this.userRepository.findByEmail(email);
    }

}
