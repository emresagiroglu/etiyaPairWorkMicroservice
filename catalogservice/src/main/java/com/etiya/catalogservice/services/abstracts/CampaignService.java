package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.dtos.campaign.*;
import com.etiya.catalogservice.entities.Campaign;

import java.util.List;
import java.util.UUID;

public interface CampaignService {

    CreatedCampaignResponseDto add(CreateCampaignRequestDto createCampaignRequestDto);
    GetCampaignResponseDto getById(UUID id);

    List<ListCampaignResponseDto> getAll();

    UpdatedCampaignResponseDto update(UUID id, UpdateCampaignRequestDto updateCampaignRequestDto);

    void delete(UUID id);

    Campaign findById(UUID id);

}
