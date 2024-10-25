package org.example.cartservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddItemRequestDto {

    private Long customerId;
    private UUID productId;
    private Integer quantity;

}
