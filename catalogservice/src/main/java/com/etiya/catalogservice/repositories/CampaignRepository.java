package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CampaignRepository extends JpaRepository<Campaign, UUID> {

    Optional<Campaign> findByIdAndIsActiveTrue(UUID id);
    Optional<List<Campaign>> findAllByIsActiveTrue();
}
