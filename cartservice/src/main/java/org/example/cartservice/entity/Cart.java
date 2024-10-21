package org.example.cartservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cartservice.core.BaseEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
public class Cart implements Serializable {

    private UUID id;
    private Long customerId;
    private Boolean status;
    private List<CartItem> cartItemList;


    public Cart() {
        this.id = UUID.randomUUID();
        this.cartItemList = new ArrayList<>();
    }
}
