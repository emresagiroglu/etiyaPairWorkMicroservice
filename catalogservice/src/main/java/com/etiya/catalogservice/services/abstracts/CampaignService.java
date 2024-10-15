package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.dtos.campaign.*;

import java.util.List;

public interface CampaignService {

    CreatedCampaignResponseDto add(CreateCampaignRequestDto createCampaignRequestDto);

//    UpdatedCampaignResponseDto update(UpdateCampaignRequestDto updateCampaignRequestDto, String id);
//    List<ListCampaignResponseDto> getAll();
//    GetCampaignResponseDto getById(String id);
//    void delete(String id);

}
