package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.customerBasedOffer.*;
import com.etiya.catalogservice.dtos.customerBasedOffer.*;
import com.etiya.catalogservice.entities.CustomerBasedOffer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerBasedOfferMapper {

    CustomerBasedOfferMapper INSTANCE = Mappers.getMapper(CustomerBasedOfferMapper.class);

    CreatedCustomerBasedOfferResponseDto createCustomerBasedOfferResponseDtoFromCustomerBasedOffer(CustomerBasedOffer customerBasedOffer);
    GetCustomerBasedOfferResponseDto getCustomerBasedOfferResponseDtoFromCustomerBasedOffer(CustomerBasedOffer customerBasedOffer);
    List<ListCustomerBasedOfferResponseDto> listCustomerBasedOfferResponseDtoFromCustomerBasedOffer(List<CustomerBasedOffer> dto);
    CustomerBasedOffer customerBasedOfferFromCreateCustomerBasedOfferRequestDto(CreateCustomerBasedOfferRequestDto dto);
    CustomerBasedOffer customerBasedOfferFromUpdateCustomerBasedOfferRequestDto(UpdateCustomerBasedOfferRequestDto dto);
    UpdatedCustomerBasedOfferResponseDto updateCustomerBasedOfferResponseDtoFromCustomerBasedOffer(CustomerBasedOffer dto);

}
