package org.example.orderservice.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemResponse {
    private UUID productId;
    private String productName;
    private Integer quantity;
    private Double price;
    private Double discount;
    private Integer totalItemAmount;
}
