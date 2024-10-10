package org.example.orderservice.service;

import org.example.orderservice.dto.CreateOrderRequest;
import org.example.orderservice.entity.Order;

import java.util.List;

public interface OrderService {
    void add(CreateOrderRequest orderRequest);

    List<Order> getAll();
}
