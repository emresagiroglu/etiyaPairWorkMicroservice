package org.example.orderservice.dto.orderitem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderItemResponseDto {
    private UUID id;
    private UUID orderId;
    private UUID productId;
    private int quantity;
    private int price;
    private int discount;
    private int totalItemAmount;
}
