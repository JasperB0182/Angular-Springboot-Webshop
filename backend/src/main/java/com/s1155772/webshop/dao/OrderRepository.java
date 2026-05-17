package com.s1155772.webshop.dao;

import com.s1155772.webshop.models.CustomUser;
import com.s1155772.webshop.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByUser(CustomUser user);
}
