package org.example.orderservice.repository;

import org.example.orderservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface OrderRepository extends MongoRepository<Order, UUID> {
}
