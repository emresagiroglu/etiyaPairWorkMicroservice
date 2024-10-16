package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.ProductCampaignPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductCampaignPackageRepository extends JpaRepository<ProductCampaignPackage, UUID> {
}
