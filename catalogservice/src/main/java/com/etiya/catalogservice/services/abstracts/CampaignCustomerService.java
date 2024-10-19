package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.dtos.campaignCustomer.*;
import com.etiya.catalogservice.dtos.category.*;

import java.util.List;
import java.util.UUID;

public interface CampaignCustomerService {

    CreatedCampaignCustomerResponseDto add(CreateCampaignCustomerRequestDto createCampaignCustomerRequestDto);

    GetCampaignCustomerResponseDto getById(UUID id);

    List<ListCampaignCustomerResponseDto> getAll();

    UpdatedCampaignCustomerResponseDto update(UUID id, UpdateCampaignCustomerRequestDto updateCampaignCustomerRequestDto);

    void delete(UUID id);


}
