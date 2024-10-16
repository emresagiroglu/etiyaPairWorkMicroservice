package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.offerProduct.*;
import com.etiya.catalogservice.entities.OfferProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OfferProductMapper {

    OfferProductMapper INSTANCE = Mappers.getMapper(OfferProductMapper.class);

    CreatedOfferProductResponseDto createOfferProductResponseDtoFromOfferProduct(OfferProduct offerProduct);
    GetOfferProductResponseDto getOfferProductResponseDtoFromOfferProduct(OfferProduct offerProduct);
    List<ListOfferProductResponseDto> listOfferProductResponseDtoFromOfferProduct(List<OfferProduct> dto);
    OfferProduct offerProductFromCreateOfferProductRequestDto(CreateOfferProductRequestDto dto);
    OfferProduct offerProductFromUpdateOfferProductRequestDto(UpdateOfferProductRequestDto dto);
    UpdatedOfferProductResponseDto updateOfferProductResponseDtoFromOfferProduct(OfferProduct dto);
}
