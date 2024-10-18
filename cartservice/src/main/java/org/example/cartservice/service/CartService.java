package org.example.cartservice.service;

import org.example.cartservice.entity.Cart;

import java.util.Map;
import java.util.UUID;

public interface CartService {



    void add(Long customerId, UUID productId);

    Map<String, Cart> getItems();
}
