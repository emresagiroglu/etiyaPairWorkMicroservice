package org.example.cartservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddItemRequestDto {
    @NotNull
    private Long customerId;
    @NotNull
    private UUID productId;
    @NotNull
    private Integer quantity;

}
