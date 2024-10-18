package org.example.cartservice.repository;

import org.example.cartservice.entity.Cart;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
public class RedisRepository {
    public static final String Key="Cart";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String,String, Cart> hashOperations;

    public RedisRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations=redisTemplate.opsForHash();
    }

    public Map<String,Cart> getAllItems(){
        return this.hashOperations.entries(Key);
    }

    public void addItem(Cart cart){
        this.hashOperations.put(Key,cart.getId()+"_"+cart.getCustomerId(),cart);
    }

    public Cart getBasketByCustomerId(Long customerId) {
        return hashOperations.entries(Key).values().stream()
                .filter(basket -> customerId.equals(basket.getCustomerId()))
                .findFirst()
                .orElse(null);
    }
}