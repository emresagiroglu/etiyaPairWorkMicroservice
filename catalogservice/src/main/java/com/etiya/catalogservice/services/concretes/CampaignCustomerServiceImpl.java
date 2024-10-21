package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.dtos.campaignCustomer.*;
import com.etiya.catalogservice.entities.Campaign;
import com.etiya.catalogservice.entities.CampaignCustomer;
import com.etiya.catalogservice.mappers.CampaignCustomerMapper;
import com.etiya.catalogservice.repositories.CampaignCustomerRepository;
import com.etiya.catalogservice.services.abstracts.CampaignCustomerService;
import com.etiya.catalogservice.services.abstracts.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CampaignCustomerServiceImpl implements CampaignCustomerService {

    private final CampaignCustomerRepository campaignCustomerRepository;
    private final CampaignService campaignService;

    @Override
    public CreatedCampaignCustomerResponseDto add(CreateCampaignCustomerRequestDto createCampaignCustomerRequest) {
        CampaignCustomer campaignCustomer = CampaignCustomerMapper.INSTANCE.campaignCustomerFromCreateCampaignCustomerRequestDto(createCampaignCustomerRequest);
        CampaignCustomer createdCampaignCustomer = campaignCustomerRepository.save(campaignCustomer);

        CreatedCampaignCustomerResponseDto response =
                CampaignCustomerMapper.INSTANCE.createdCampaignCustomerResponseDtoFromCampaignCustomer(createdCampaignCustomer);


        return response;
    }

    @Override
    public GetCampaignCustomerResponseDto getById(UUID id) {
        CampaignCustomer campaignCustomer = campaignCustomerRepository.findById(id).orElseThrow();

        GetCampaignCustomerResponseDto response =
                CampaignCustomerMapper.INSTANCE.getCampaignCustomerResponseDtoFromCampaignCustomer(campaignCustomer);

        return response;
    }

    @Override
    public List<ListCampaignCustomerResponseDto> getAll() {
        List<CampaignCustomer> campaignCustomerList = campaignCustomerRepository.findAll();
        List<ListCampaignCustomerResponseDto> getAllCampaignCustomerResponseList = CampaignCustomerMapper.INSTANCE.listCampaignCustomerResponseDtoFromCampaignCustomer(campaignCustomerList);

        return getAllCampaignCustomerResponseList;
    }

    @Override
    public UpdatedCampaignCustomerResponseDto update(UUID id, UpdateCampaignCustomerRequestDto updateCampaignCustomerRequestDto) {
        CampaignCustomer campaignCustomer = campaignCustomerRepository.findById(id).orElseThrow();

        Campaign campaign = campaignService.findById(updateCampaignCustomerRequestDto.getCampaignId());

        campaignCustomer.setCustomerId(updateCampaignCustomerRequestDto.getCustomerId());
        campaignCustomer.setAddressId(updateCampaignCustomerRequestDto.getAddressId());
        campaignCustomer.setCampaign(campaign);

        campaignCustomerRepository.save(campaignCustomer);

        UpdatedCampaignCustomerResponseDto response = CampaignCustomerMapper.INSTANCE.updatedCampaignCustomerResponseDtoFromCampaignCustomer(campaignCustomer);

        return response;
    }

    @Override
    public void delete(UUID id) {
        campaignCustomerRepository.deleteById(id);
    }


}
