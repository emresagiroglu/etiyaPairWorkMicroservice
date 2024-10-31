package org.example.cartservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.cartservice.dto.AddItemRequestDto;
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
    public void addItem(@Valid @RequestBody AddItemRequestDto addItemRequestDto)
    {
        cartService.add(addItemRequestDto);
    }

    @GetMapping
    public Map<String, Cart> getItems(){
        return cartService.getItems();
    }

    @GetMapping("/{customerId}")
    public Cart getCartByCustomerId(@PathVariable Long customerId)
    {
        return cartService.getCartByCustomerId(customerId);
    }
}
