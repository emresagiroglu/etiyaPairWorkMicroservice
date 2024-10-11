package com.etiya.customerservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customers")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(name = "CreatedDate")
    private Date createdDate;

    @Column(name = "UpdatedDate")
    private Date updatedDate;

    @Column(name = "DeletedDate")
    private Date deletedDate;

}
