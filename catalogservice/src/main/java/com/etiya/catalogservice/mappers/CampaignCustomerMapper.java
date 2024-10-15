package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.campaign.*;
import com.etiya.catalogservice.dtos.campaignCustomer.*;
import com.etiya.catalogservice.entities.CampaignCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CampaignCustomerMapper {

    CampaignCustomerMapper INSTANCE = Mappers.getMapper(CampaignCustomerMapper.class);

    CreatedCampaignCustomerResponseDto createdCampaignCustomerResponseDtoFromCampaignCustomer(CampaignCustomer campaignCustomer);
    GetCampaignCustomerResponseDto getCampaignCustomerResponseDtoFromCampaignCustomer(CampaignCustomer campaignCustomer);
    List<ListCampaignCustomerResponseDto> listCampaignCustomerResponseDtoFromCampaignCustomer(List<CampaignCustomer> dto);
    CampaignCustomer campaignCustomerFromCreateCampaignCustomerRequestDto(CreateCampaignCustomerRequestDto dto);
    CampaignCustomer campaignCustomerFromUpdateCampaignCustomerRequestDto(UpdateCampaignCustomerRequestDto dto);
    UpdatedCampaignCustomerResponseDto updatedCampaignCustomerResponseDtoFromCampaignCustomer(CampaignCustomer dto);
}
