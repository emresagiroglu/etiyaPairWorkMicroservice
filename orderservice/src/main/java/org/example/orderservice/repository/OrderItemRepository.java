package org.example.orderservice.repository;

import org.example.orderservice.entity.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OrderItemRepository extends MongoRepository<OrderItem, UUID> {
}
