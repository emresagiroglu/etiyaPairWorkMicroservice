package org.example.cartservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cartservice.core.BaseEntity;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem extends BaseEntity {


//    private Cart cartId;
//    private UUID productId;
//    private String productName;
    private Integer quantity;
    private Double price;
    private Double discount;
    private Integer totalItemAmount;

    // bunu analizciilere sor!
    //TODO: entity yapısı değiştirilsin.!
}
