package org.example.cartservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cartservice.core.BaseEntity;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart extends BaseEntity {

    private Long customerId;
    private Boolean status;
    private List<CartItem> cartItemList;

}
