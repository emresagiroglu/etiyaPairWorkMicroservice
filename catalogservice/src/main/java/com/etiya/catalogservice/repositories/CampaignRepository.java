package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CampaignRepository extends JpaRepository<Campaign, UUID> {
}
