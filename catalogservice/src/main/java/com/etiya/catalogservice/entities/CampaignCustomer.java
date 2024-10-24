package com.etiya.catalogservice.entities;

import com.etiya.catalogservice.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "campaign_customers")
@Entity
public class CampaignCustomer extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "addressId")
    private Long addressId;

    //customer id
    //address id var başka mikroserviste!
}
