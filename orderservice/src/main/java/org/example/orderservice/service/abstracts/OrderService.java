package org.example.orderservice.service.abstracts;

import org.example.orderservice.dto.order.*;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    CreateOrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto);
    UpdateOrderResponseDto updateOrder(UpdateOrderRequestDto updateOrderRequestDto);
    void deleteOrder(UUID id);
    List<ListOrderResponseDto> getAllOrders();
    GetOrderResponseDto getOrderById(UUID id);
}

