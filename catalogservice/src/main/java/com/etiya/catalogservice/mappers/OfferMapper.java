package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.offer.*;
import com.etiya.catalogservice.entities.Offer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OfferMapper {

    OfferMapper INSTANCE = Mappers.getMapper(OfferMapper.class);

    CreatedOfferResponseDto createOfferResponseDtoFromOffer(Offer offer);
    GetOfferResponseDto getOfferResponseDtoFromOffer(Offer offer);
    List<ListOfferResponseDto> listOfferResponseDtoFromOffer(List<Offer> dto);
    Offer offerFromCreateOfferRequestDto(CreateOfferRequestDto dto);
    Offer offerFromUpdateOfferRequestDto(UpdateOfferRequestDto dto);
    UpdatedOfferResponseDto updateOfferResponseDtoFromOffer(Offer dto);

}
