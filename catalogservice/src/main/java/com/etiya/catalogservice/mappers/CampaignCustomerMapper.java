package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.campaign.*;
import com.etiya.catalogservice.dtos.campaignCustomer.*;
import com.etiya.catalogservice.entities.CampaignCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CampaignCustomerMapper {

    CampaignCustomerMapper INSTANCE = Mappers.getMapper(CampaignCustomerMapper.class);

    @Mapping(target = "campaignId",source = "campaign.id")
    CreatedCampaignCustomerResponseDto createdCampaignCustomerResponseDtoFromCampaignCustomer(CampaignCustomer campaignCustomer);

    @Mapping(target = "campaignId",source = "campaign.id")
    GetCampaignCustomerResponseDto getCampaignCustomerResponseDtoFromCampaignCustomer(CampaignCustomer campaignCustomer);

    @Mapping(target = "campaignId",source = "campaign.id")
    default List<ListCampaignCustomerResponseDto> listCampaignCustomerResponseDtoFromCampaignCustomer(List<CampaignCustomer> dtos){
        List<ListCampaignCustomerResponseDto> responseDtos = dtos.stream().map(campaignCustomer ->
                new ListCampaignCustomerResponseDto(
                        campaignCustomer.getId(),
                        campaignCustomer.getCampaign().getId(),
                        campaignCustomer.getCustomerId(),
                        campaignCustomer.getAddressId()
                )).toList();
        return responseDtos;
    }
    @Mapping(target = "campaign.id",source = "campaignId")
    CampaignCustomer campaignCustomerFromCreateCampaignCustomerRequestDto(CreateCampaignCustomerRequestDto dto);

    @Mapping(target = "campaign.id",source = "campaignId")
    CampaignCustomer campaignCustomerFromUpdateCampaignCustomerRequestDto(UpdateCampaignCustomerRequestDto dto);

    @Mapping(target = "campaignId",source = "campaign.id")
    UpdatedCampaignCustomerResponseDto updatedCampaignCustomerResponseDtoFromCampaignCustomer(CampaignCustomer dto);
}
