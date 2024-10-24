package org.example.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@AllArgsConstructor
@Document(collection = "order_items")
public class OrderItem {
    @Id
    private UUID id;
    private UUID productId;
    private int quantity;
    private Double price;
    private String productName;
    //private int discount; //todo : bu ne!
    private int totalItemAmount;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;

    public OrderItem()
    {
        this.id = UUID.randomUUID();
    }

}
