package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.dtos.campaign.*;
import com.etiya.catalogservice.entities.Campaign;

import java.util.List;
import java.util.UUID;

public interface CampaignService {

    CreatedCampaignResponseDto add(CreateCampaignRequestDto createCampaignRequestDto);

//    UpdatedCampaignResponseDto update(UpdateCampaignRequestDto updateCampaignRequestDto, String id);
//    List<ListCampaignResponseDto> getAll();
//    GetCampaignResponseDto getById(String id);
//    void delete(String id);

    Campaign findById(UUID id);

}
