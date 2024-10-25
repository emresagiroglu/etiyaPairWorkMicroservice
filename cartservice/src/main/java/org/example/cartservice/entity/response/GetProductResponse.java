package org.example.cartservice.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductResponse {

    private UUID id;
    private String name;
    private Double price;
}
