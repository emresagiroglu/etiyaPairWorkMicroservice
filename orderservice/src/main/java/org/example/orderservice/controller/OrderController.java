package org.example.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.orderservice.dto.order.*;
import org.example.orderservice.service.abstracts.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;


    @GetMapping()
    public ResponseEntity<List<ListOrderResponseDto>> getAll()
    {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetOrderResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponseDto> createOrder
            (@RequestBody CreateOrderRequestDto createOrderRequestDto)
    {
        return ResponseEntity.ok(orderService.createOrder(createOrderRequestDto));
    }

    // Sipariş günceller (UpdateOrderRequestDto kullanarak)
    @PutMapping("/{id}")
    public ResponseEntity<UpdateOrderResponseDto> updateOrderCustomer(
            @PathVariable UUID id,
            @RequestBody UpdateOrderRequestDto updateOrderRequestDto)
    {
        return ResponseEntity.ok(orderService.updateOrder(updateOrderRequestDto));
    }

    // Sipariş siler (ID ile)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable UUID id)
    {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
