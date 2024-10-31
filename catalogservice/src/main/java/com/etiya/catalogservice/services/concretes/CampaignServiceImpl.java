package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.core.exception.type.BusinessException;
import com.etiya.catalogservice.dtos.campaign.CreateCampaignRequestDto;
import com.etiya.catalogservice.dtos.campaign.CreatedCampaignResponseDto;
import com.etiya.catalogservice.dtos.campaign.*;
import com.etiya.catalogservice.entities.Campaign;
import com.etiya.catalogservice.entities.Offer;
import com.etiya.catalogservice.mappers.CampaignMapper;
import com.etiya.catalogservice.repositories.CampaignRepository;
import com.etiya.catalogservice.services.abstracts.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CampaignServiceImpl implements CampaignService {


    private final CampaignRepository campaignRepository;

    @Override
    public CreatedCampaignResponseDto add(CreateCampaignRequestDto createCampaignRequest) {
        Campaign campaign = CampaignMapper.INSTANCE.campaignFromCreateCampaignRequestDto(createCampaignRequest);
        Campaign createdCampaign = campaignRepository.save(campaign);

        CreatedCampaignResponseDto response =
                CampaignMapper.INSTANCE.createdCampaignResponseDtoFromCampaign(createdCampaign);


        return response;
    }

    @Override
    public GetCampaignResponseDto getById(UUID id) {
        Campaign campaign = campaignRepository.findById(id).orElseThrow();

        GetCampaignResponseDto response =
                CampaignMapper.INSTANCE.getCampaignResponseDtoFromCampaign(campaign);

        return response;
    }

    @Override
    public List<ListCampaignResponseDto> getAll() {
        List<Campaign> campaignList = campaignRepository.findAllByIsActiveTrue()
                .orElseThrow(() -> new BusinessException("There is no active Campaigns"));
        List<ListCampaignResponseDto> getAllCampaignResponseList = CampaignMapper.INSTANCE.listCampaignResponseDtoFromCampaign(campaignList);

        return getAllCampaignResponseList;
    }

    @Override
    public UpdatedCampaignResponseDto update(UUID id, UpdateCampaignRequestDto updateCampaignRequestDto) {
        Campaign campaign = campaignRepository.findById(id).orElseThrow();

        campaign.setName(updateCampaignRequestDto.getName());
        campaign.setStartDate(updateCampaignRequestDto.getStartDate());
        campaign.setEndDate(updateCampaignRequestDto.getEndDate());
        campaign.setDiscountPercentage(updateCampaignRequestDto.getDiscountPercentage());
        campaign.setDiscountDesc(updateCampaignRequestDto.getDiscountDesc());

        campaignRepository.save(campaign);

        UpdatedCampaignResponseDto response = CampaignMapper.INSTANCE.updatedCampaignResponseDtoFromCampaign(campaign);

        return response;
    }

    @Override
    public void delete(UUID id) {
        Campaign campaign = campaignRepository.
                findByIdAndIsActiveTrue(id).
                orElseThrow(() -> new BusinessException("There is no active Campaign with this id: " + id));
        campaign.setIsActive(false);
        campaignRepository.save(campaign);
    }

    @Override
    public Campaign findById(UUID id) {
        return campaignRepository.
                findByIdAndIsActiveTrue(id).
                orElseThrow(() -> new BusinessException("There is no active Campaign with this id: " + id));
    }
}
