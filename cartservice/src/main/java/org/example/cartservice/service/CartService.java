package org.example.cartservice.service;

import org.example.cartservice.dto.AddItemRequestDto;
import org.example.cartservice.entity.Cart;

import java.util.Map;
import java.util.UUID;

public interface CartService {



    void add(AddItemRequestDto addItemRequestDto);

    Map<String, Cart> getItems();

    Cart getCartByCustomerId(Long customerId);
}
