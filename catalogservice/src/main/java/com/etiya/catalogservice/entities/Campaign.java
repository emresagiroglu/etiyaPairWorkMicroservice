package com.etiya.catalogservice.entities;

import com.etiya.catalogservice.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Table(name = "campaigns")
@Entity
public class Campaign extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "discount_percentage")
    private int discountPercentage;

    @Column(name = "dicount_desc")
    private String discountDesc;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "campaign")
    private List<ProductCampaignPackage> productCampaignPackages;

    @OneToMany(mappedBy = "campaign")
    private List<CampaignCustomer> campaignCustomers;

    public Campaign(){
        this.setIsActive(true);
    }
}
