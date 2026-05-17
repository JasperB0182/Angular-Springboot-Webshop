package com.s1155772.webshop.dao;

import com.s1155772.webshop.models.CustomUser;
import com.s1155772.webshop.models.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderDAO {

    private OrderRepository orderRepository;

    public OrderDAO(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<List<Order>> getUserOrders(CustomUser user) {
        return Optional.ofNullable(this.orderRepository.findOrdersByUser(user));
    }

    public void saveToDatabase(Order order) {
        orderRepository.save(order);
    }
}
