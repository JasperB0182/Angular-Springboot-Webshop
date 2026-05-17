package com.s1155772.webshop.controllers;


import com.s1155772.webshop.dao.OrderDAO;
import com.s1155772.webshop.dao.ProductDAO;
import com.s1155772.webshop.dao.UserDAO;
import com.s1155772.webshop.dto.OrderDTO;
import com.s1155772.webshop.models.*;
import com.s1155772.webshop.services.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/order")
public class OrderController {

    private OrderDAO orderDAO;

    private UserDAO userDAO;

    private ProductDAO productDAO;

    private UserService userService;


    public OrderController(OrderDAO orderDAO, UserDAO userDAO, ProductDAO productDAO, UserService userService) {
        this.orderDAO = orderDAO;
        this.userDAO = userDAO;
        this.productDAO = productDAO;
        this.userService = userService;
    }

    @PostMapping("/plaats")
    public void setNewOrder(@Valid @RequestBody OrderDTO orderDTO){
        List<Product> productList = orderDTO.getProducts();

        String address = orderDTO.getAddress();

        String fullName = orderDTO.getFullname();

        String city = orderDTO.getCity();

        String postcode = orderDTO.getZipcode();

        CustomUser customUser = userService.getCurrentUser();

        Order order = new Order(LocalDate.now(), customUser, address, fullName, city, postcode, (float) 0);

        List<OrderProduct> orderProductList = new ArrayList<>();

        float totalePrijs = 0;

        for (Product product : productList){
            if (product.getAmountInCart() <= 0 ){
                product.setAmountInCart(0);
            }
            Product originalProduct = this.productDAO.findByProductId((long) product.getProductId());
            float prijs = (originalProduct.getPrice() * product.getAmountInCart());
            totalePrijs += prijs;
            Long productId = (long) product.getProductId();
            int aantalInWinkelwagen = product.getAmountInCart();
            if (aantalInWinkelwagen > 100000){
                aantalInWinkelwagen = 99999;
            }
            Product Product = this.productDAO.findByProductId(productId);
            OrderProduct orderProduct = new OrderProduct(aantalInWinkelwagen, order, Product);
            orderProductList.add(orderProduct);

        }
        order.setTotalPrice(totalePrijs);

        order.setOrderProducts(orderProductList);

        this.orderDAO.saveToDatabase(order);


    }

    @GetMapping
    public Optional<List<Order>> getMyOrders() {
        CustomUser customUser = this.userService.getCurrentUser();

        return this.orderDAO.getUserOrders(customUser);
    }
}
