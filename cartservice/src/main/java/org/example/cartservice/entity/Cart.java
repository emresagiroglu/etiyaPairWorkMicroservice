package org.example.cartservice.entity;

import org.example.cartservice.core.BaseEntity;

import java.util.Date;
import java.util.UUID;

public class Cart extends BaseEntity {

    private Long customerId;
    private Boolean status;
    private Date createdTime;
    private Date uploadedTime;
    private Date deletedTime;
// saçmalık ötesi!
    //TODO: entity yapısı değiştirilsin.!
}
