package org.example.orderservice.service.abstracts;

import org.example.orderservice.dto.order.*;
import org.example.orderservice.dto.orderitem.*;

import java.util.List;
import java.util.UUID;

public interface OrderItemService {
    CreateOrderItemResponseDto createOrderItem(CreateOrderItemRequestDto createOrderItemRequestDto);
    UpdateOrderItemResponseDto updateOrderItem(UpdateOrderItemRequestDto updateOrderItemRequestDto);
    void deleteOrderItem(UUID id);
    List<ListOrderItemResponseDto> getAllOrderItems();
    GetOrderItemResponseDto getOrderItemById(UUID id);
}
