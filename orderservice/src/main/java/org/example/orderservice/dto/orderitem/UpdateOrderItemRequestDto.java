package org.example.orderservice.dto.orderitem;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderItemRequestDto {
    @NotNull
    private UUID orderId;
    @NotNull
    private UUID productId;
    @NotNull
    private int quantity;
    @NotNull
   // private int discount;
    @NotNull
    private int totalItemAmount;
}
