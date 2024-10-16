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
@Entity
@Table(name = "cart_item")
public class CartItem extends BaseEntity {


    private Long customerId;
    private UUID productId;
    private Integer quantity;
    private Double price;
    private Double discount;
    private Integer totalItemAmount;
    private Date addedTime;
    private Date removedTime;


    // bunu analizciilere sor!
    //TODO: entity yapısı değiştirilsin.!
}
