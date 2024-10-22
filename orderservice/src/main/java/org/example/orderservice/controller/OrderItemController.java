package org.example.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.orderservice.dto.orderitem.*;
import org.example.orderservice.service.abstracts.OrderItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orderitems")
@RequiredArgsConstructor
public class OrderItemController {
    private final OrderItemService orderItemService;


    @GetMapping()
    public ResponseEntity<List<ListOrderItemResponseDto>> getAll()
    {
        return ResponseEntity.ok(orderItemService.getAllOrderItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetOrderItemResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(orderItemService.getOrderItemById(id));
    }

    @PostMapping
    public ResponseEntity<CreateOrderItemResponseDto> createOrderItem
            (@RequestBody CreateOrderItemRequestDto createOrderItemRequestDto)
    {
        return ResponseEntity.ok(orderItemService.createOrderItem(createOrderItemRequestDto));
    }

    // Sipariş günceller (UpdateOrderItemRequestDto kullanarak)
    @PutMapping("/{id}")
    public ResponseEntity<UpdateOrderItemResponseDto> updateOrderItemCustomer(
            @PathVariable UUID id,
            @RequestBody UpdateOrderItemRequestDto updateOrderItemRequestDto)
    {
        return ResponseEntity.ok(orderItemService.updateOrderItem(updateOrderItemRequestDto));
    }

    // Sipariş siler (ID ile)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable UUID id)
    {
        orderItemService.deleteOrderItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
