package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.customerBasedOffer.*;
import com.etiya.catalogservice.entities.CustomerBasedOffer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerBasedOfferMapper {

    CustomerBasedOfferMapper INSTANCE = Mappers.getMapper(CustomerBasedOfferMapper.class);

    @Mapping(target = "offerId",source = "offer.id")
    CreatedCustomerBasedOfferResponseDto createCustomerBasedOfferResponseDtoFromCustomerBasedOffer(CustomerBasedOffer customerBasedOffer);
    @Mapping(target = "offerId",source = "offer.id")
    GetCustomerBasedOfferResponseDto getCustomerBasedOfferResponseDtoFromCustomerBasedOffer(CustomerBasedOffer customerBasedOffer);

    @Mapping(target = "offerId",source = "offer.id")
    default List<ListCustomerBasedOfferResponseDto> listCustomerBasedOfferResponseDtoFromCustomerBasedOffer(List<CustomerBasedOffer> dtos){
        List<ListCustomerBasedOfferResponseDto> responseDtos = dtos.stream().map(customerBasedOffer ->
                new ListCustomerBasedOfferResponseDto(
                        customerBasedOffer.getId(),
                        customerBasedOffer.getOffer().getId(),
                        customerBasedOffer.getCustomerId())).toList();
        return responseDtos;
    }

    @Mapping(target = "offer.id",source = "offerId")
    CustomerBasedOffer customerBasedOfferFromCreateCustomerBasedOfferRequestDto(CreateCustomerBasedOfferRequestDto dto);

    @Mapping(target = "offer.id",source = "offerId")
    CustomerBasedOffer customerBasedOfferFromUpdateCustomerBasedOfferRequestDto(UpdateCustomerBasedOfferRequestDto dto);

    @Mapping(target = "offerId",source = "offer.id")
    UpdatedCustomerBasedOfferResponseDto updateCustomerBasedOfferResponseDtoFromCustomerBasedOffer(CustomerBasedOffer dto);

}
