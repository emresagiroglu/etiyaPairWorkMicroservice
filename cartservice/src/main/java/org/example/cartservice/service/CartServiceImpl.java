package org.example.cartservice.service;

import lombok.RequiredArgsConstructor;
import org.example.cartservice.client.CatalogServiceClient;
import org.example.cartservice.client.CustomerServiceClient;
import org.example.cartservice.entity.Cart;
import org.example.cartservice.entity.CartItem;
import org.example.cartservice.entity.response.GetCustomerResponse;
import org.example.cartservice.entity.response.GetProductResponse;
import org.example.cartservice.repository.RedisRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final RedisRepository redisRepository;
    private final CustomerServiceClient customerServiceClient;
    private final CatalogServiceClient catalogServiceClient;


    @Override
    public void add(Long customerId, UUID productId) {
        Cart cart = redisRepository.getCartByCustomerId(customerId);
        if (cart==null){
            cart= new Cart();
            cart.setCustomerId(customerId);
        }

        // todo : setleri düzelt

        //GetCustomerResponse response = customerServiceClient.getById(customerId);
        GetProductResponse productResponse = catalogServiceClient.getById(productId);
        CartItem cartItem = new CartItem();
        System.out.println(productResponse);
        //cartItem.setQuantity(response.getName());
        //cartItem.setPrice(response.getTotalPrice());
        cart.setCustomerId(customerId);
        //basket.setTotalPrice(basket.getTotalPrice()+basketItem.getPrice());
        cart.getCartItemList().add(cartItem);
        redisRepository.addItem(cart);
    }

    @Override
    public Map<String, Cart> getItems() {
        return redisRepository.getAllItems();
    }
}


// todo: redis bağlantısını kur!