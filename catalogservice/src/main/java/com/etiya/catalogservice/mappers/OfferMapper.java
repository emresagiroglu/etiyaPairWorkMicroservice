package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.offer.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OfferMapper {

    OfferMapper INSTANCE = Mappers.getMapper(OfferMapper.class);

    CreatedOfferResponseDto createOfferResponseDtoFromOffer(OfferMapper offer);
    GetOfferResponseDto getOfferResponseDtoFromOffer(OfferMapper offer);
    List<ListOfferResponseDto> listOfferResponseDtoFromOffer(List<OfferMapper> dto);
    OfferMapper offerFromCreateOfferRequestDto(CreateOfferRequestDto dto);
    OfferMapper offerFromUpdateOfferRequestDto(UpdateOfferRequestDto dto);
    UpdatedOfferResponseDto updateOfferResponseDtoFromOffer(OfferMapper dto);

}
