package org.example.orderservice.entity;


import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "orders")
public class Order
{
    @Id
    private UUID id;
    private Long customerId;
    private Long billingAccountId;
    private List<OrderItem> orderItemList;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;


    public Order()
    {
        this.id = UUID.randomUUID();
    }

}
