package org.example.orderservice.service.concretes;

import lombok.RequiredArgsConstructor;
import org.example.orderservice.client.CatalogServiceClient;
import org.example.orderservice.dto.orderitem.*;
import org.example.orderservice.entity.OrderItem;
import org.example.orderservice.entity.response.ProductResponse;
import org.example.orderservice.mapper.OrderItemMapper;
import org.example.orderservice.repository.OrderItemRepository;
import org.example.orderservice.service.abstracts.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final CatalogServiceClient catalogServiceClient;
    @Override
    public CreateOrderItemResponseDto createOrderItem(CreateOrderItemRequestDto createOrderItemRequestDto) {
        // create order requesti -> order item' a maple

        OrderItem orderItem = OrderItemMapper.INSTANCE.orderItemFromCreateOrderItemRequestDto(createOrderItemRequestDto);
        // price column'unu openfeign ile istek at
        ProductResponse productResponse = catalogServiceClient.getById(createOrderItemRequestDto.getProductId());
        orderItem.setPrice(productResponse.getPrice());
        orderItem.setProductName(productResponse.getName());
        //savele
        orderItemRepository.save(orderItem);
        System.out.println(orderItem);
        return OrderItemMapper.INSTANCE.creatOrderItemResponseDtoFromOrderItem(orderItem);
    }

    @Override
    public UpdateOrderItemResponseDto updateOrderItem(UpdateOrderItemRequestDto updateOrderItemRequestDto) {
        OrderItem orderItem = OrderItemMapper.INSTANCE.orderItemFromUpdateRequestDto(updateOrderItemRequestDto);
        orderItemRepository.save(orderItem);
        return OrderItemMapper.INSTANCE.updateOrderItemResponseDtoFromOrderItem(orderItem);
    }

    @Override
    public void deleteOrderItem(UUID id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public List<ListOrderItemResponseDto> getAllOrderItems() {
        List<OrderItem> orderItemList = orderItemRepository.findAll();
        return OrderItemMapper.INSTANCE.getAllOrderItemsResponseDtoFromOrderItems(orderItemList);
    }

    @Override
    public GetOrderItemResponseDto getOrderItemById(UUID id) {
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow();
        return OrderItemMapper.INSTANCE.getOrderItemResponseFromOrderItem(orderItem);
    }
}
