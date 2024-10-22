package org.example.orderservice.mapper;


import org.example.orderservice.dto.order.*;
import org.example.orderservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    Order orderFromCreateOrderRequestDto
            (CreateOrderRequestDto createOrderRequestDto);

    GetOrderResponseDto getOrderResponseFromOrder
            (Order order);

    List<ListOrderResponseDto> getAllOrdersResponseDtoFromOrders
            (List<Order> order);

    CreateOrderResponseDto creatOrderResponseDtoFromOrder
            (Order order);

    Order orderFromUpdateRequestDto (UpdateOrderRequestDto updateOrderRequestDto);

    UpdateOrderResponseDto updateOrderResponseDtoFromOrder (Order order);
}
