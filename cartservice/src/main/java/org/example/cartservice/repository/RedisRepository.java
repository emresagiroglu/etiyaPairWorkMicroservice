package org.example.cartservice.repository;

import org.example.cartservice.entity.Cart;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;

@Repository
public class RedisRepository {
    public static final String Key = "Cart";  // UUID yerine sabit bir string kullanıyoruz

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, Cart> hashOperations;


    public RedisRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    public Map<String, Cart> getAllItems() {
        return this.hashOperations.entries(Key);  // Key artık String tipinde
    }

    public void addItem(Cart cart) {
        this.hashOperations.put(Key, cart.getId() + "_" + cart.getCustomerId(), cart);
    }

    public Cart getCartByCustomerId(Long customerId) {
        return hashOperations.entries(Key).values().stream()
                .filter(basket -> customerId.equals(basket.getCustomerId()))
                .findFirst()
                .orElse(null);
    }

    public void deleteItem(UUID id) {
        // UUID'yi string'e çevirip silme işlemi yapılmalı
        this.hashOperations.delete(Key, id.toString());
    }
}
