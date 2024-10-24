package org.example.orderservice.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {

    private Long customerId;
    private Boolean status;
    private List<CartItemResponse> cartItemList;

}
