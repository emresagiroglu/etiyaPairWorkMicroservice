package org.example.cartservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.cartservice.entity.Cart;
import org.example.cartservice.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/addCart")
    public void addItem(@RequestParam Long customerId, @RequestParam UUID productId)
    {
        cartService.add(customerId,productId);
    }

    @GetMapping
    public Map<String, Cart> getItems(){
        return cartService.getItems();
    }
}
