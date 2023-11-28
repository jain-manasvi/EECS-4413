package com.example.project.controller;

import com.example.project.repository.OrderRepository;
import com.example.project.repository.UserRepository;
import com.example.project.repository.model.entity.Order;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class OrderController {
    private final OrderRepository orderRepo;
    private final UserRepository userRepo;

    public OrderController(OrderRepository orderRepo, UserRepository userRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
    }

    @PostMapping("/api/orders")
    public ResponseEntity<?> addOrderItems(@RequestBody Order order, HttpSession session){
        return null;
    }


}
