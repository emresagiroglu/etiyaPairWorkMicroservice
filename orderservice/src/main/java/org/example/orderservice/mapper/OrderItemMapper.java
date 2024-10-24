package org.example.orderservice.mapper;


import org.example.orderservice.dto.orderitem.*;
import org.example.orderservice.entity.OrderItem;
import org.example.orderservice.entity.response.CartItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);
    OrderItem orderItemFromCreateOrderItemRequestDto
            (CreateOrderItemRequestDto createOrderItemRequestDto);

    GetOrderItemResponseDto getOrderItemResponseFromOrderItem
            (OrderItem orderItem);

    List<ListOrderItemResponseDto> getAllOrderItemsResponseDtoFromOrderItems
            (List<OrderItem> orderItem);

    CreateOrderItemResponseDto creatOrderItemResponseDtoFromOrderItem
            (OrderItem orderItem);

    OrderItem orderItemFromUpdateRequestDto (UpdateOrderItemRequestDto updateOrderItemRequestDto);

    UpdateOrderItemResponseDto updateOrderItemResponseDtoFromOrderItem (OrderItem orderItem);

    List<OrderItem> orderItemFromCartItemResponse (List<CartItemResponse> cartItemResponse);
}
