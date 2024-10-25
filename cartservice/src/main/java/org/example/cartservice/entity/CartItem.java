package org.example.cartservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cartservice.core.BaseEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class CartItem implements Serializable {

    private String id;
    private UUID productId;
    private String productName;
    private Integer quantity;
    private Double price;
    private Double discount;
    private Double totalItemAmount;

    // bunu analizciilere sor!
    //TODO: entity yapısı değiştirilsin.!

    public CartItem()
    {
        this.id = UUID.randomUUID().toString();
    }
}
