package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.CampaignCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CampaignCustomerRepository extends JpaRepository<CampaignCustomer, UUID> {
}
