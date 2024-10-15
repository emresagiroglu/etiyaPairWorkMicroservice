package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.campaign.*;
import com.etiya.catalogservice.entities.Campaign;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CampaignMapper {

    CampaignMapper INSTANCE = Mappers.getMapper(CampaignMapper.class);

    CreatedCampaignResponseDto createdCampaignResponseDtoFromCampaign(Campaign campaign);
    GetCampaignResponseDto getCampaignResponseDtoFromCampaign(Campaign campaign);
    List<ListCampaignResponseDto> listCampaignResponseDtoFromCampaign(List<Campaign> dto);
    Campaign campaignFromCreateCampaignRequestDto(CreateCampaignRequestDto dto);
    Campaign campaignFromUpdateCampaignRequestDto(UpdateCampaignRequestDto dto);
    UpdatedCampaignResponseDto updatedCampaignResponseDtoFromCampaign(Campaign dto);

}
