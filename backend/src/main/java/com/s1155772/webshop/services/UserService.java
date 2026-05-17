package com.s1155772.webshop.services;

import com.s1155772.webshop.dao.UserDAO;
import com.s1155772.webshop.dao.UserRepository;
import com.s1155772.webshop.models.CustomUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    private UserDAO userDAO;


    public UserService(UserRepository userRepository, UserDAO userDAO) {
        this.userRepository = userRepository;
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        CustomUser customUser = userRepository.findByEmail(email);
        return new User(
                email,
                customUser.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
    }

    public CustomUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        assert authentication != null;
        String currentUser = (String) authentication.getPrincipal();

        return this.userDAO.findByEmail(currentUser);
    }
}
