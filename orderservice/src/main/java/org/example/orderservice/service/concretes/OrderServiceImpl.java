package org.example.orderservice.service.concretes;

import lombok.RequiredArgsConstructor;
import org.example.orderservice.client.CartServiceClient;
import org.example.orderservice.client.CustomerServiceClient;
import org.example.orderservice.dto.order.*;
import org.example.orderservice.entity.Order;
import org.example.orderservice.entity.OrderItem;
import org.example.orderservice.entity.response.BillingAccountResponse;
import org.example.orderservice.entity.response.CartResponse;
import org.example.orderservice.mapper.OrderItemMapper;
import org.example.orderservice.mapper.OrderMapper;
import org.example.orderservice.repository.OrderRepository;
import org.example.orderservice.service.abstracts.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerServiceClient customerServiceClient;
    private final CartServiceClient cartServiceClient;
    @Override
    public List<ListOrderResponseDto> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        return OrderMapper.INSTANCE.getAllOrdersResponseDtoFromOrders(orderList);
    }
    @Override
    public CreateOrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto) {
        Order order = OrderMapper.INSTANCE.orderFromCreateOrderRequestDto(createOrderRequestDto);
        BillingAccountResponse billingAccountResponse = customerServiceClient.getById(createOrderRequestDto.getBillingAccountId());
        CartResponse cartResponse = cartServiceClient.getCartByCustomerId(createOrderRequestDto.getCustomerId());
        List<OrderItem> orderItem = OrderItemMapper.INSTANCE.orderItemFromCartItemResponse(cartResponse.getCartItemList());
        order.setOrderItemList(orderItem);
//        order.getOrderItemList().stream()
//                .map(orderItem -> {
//                    orderItem.setProductName(cartResponse.(orderItem.getProductId()));
//                    return orderItem;
//                }).collect(Collectors.toList());

        order.setBillingAccountId(billingAccountResponse.getId());
        orderRepository.save(order);
        return OrderMapper.INSTANCE.creatOrderResponseDtoFromOrder(order);
    }

    @Override
    public UpdateOrderResponseDto updateOrder(UpdateOrderRequestDto updateOrderRequestDto) {
        Order order = OrderMapper.INSTANCE.orderFromUpdateRequestDto(updateOrderRequestDto);
        orderRepository.save(order);
        return OrderMapper.INSTANCE.updateOrderResponseDtoFromOrder(order);
    }

    @Override
    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
    }


    // Cart - CartItem
    // Order - OrderItem
    // Orderservice -> Cart-Order CartItem-> OrderItem ?



    @Override
    public GetOrderResponseDto getOrderById(UUID id) {
        Order order = orderRepository.findById(id).orElseThrow();
        return OrderMapper.INSTANCE.getOrderResponseFromOrder(order);
    }
}
