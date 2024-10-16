package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.dtos.campaign.CreateCampaignRequestDto;
import com.etiya.catalogservice.dtos.campaign.CreatedCampaignResponseDto;
import com.etiya.catalogservice.entities.Campaign;
import com.etiya.catalogservice.mappers.CampaignMapper;
import com.etiya.catalogservice.repositories.CampaignRepository;
import com.etiya.catalogservice.services.abstracts.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CampaignServiceImpl implements CampaignService {

    private CampaignRepository campaignRepository;

    @Override
    public CreatedCampaignResponseDto add(CreateCampaignRequestDto createCampaignRequest) {
        Campaign campaign = CampaignMapper.INSTANCE.campaignFromCreateCampaignRequestDto(createCampaignRequest);
        Campaign createdCampaign = campaignRepository.save(campaign);

        CreatedCampaignResponseDto response =
                CampaignMapper.INSTANCE.createdCampaignResponseDtoFromCampaign(createdCampaign);


        return response;
    }
}
