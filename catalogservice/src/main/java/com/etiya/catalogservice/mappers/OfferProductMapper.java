package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.offerProduct.*;
import com.etiya.catalogservice.dtos.productSpec.ListProductSpecResponseDto;
import com.etiya.catalogservice.entities.OfferProduct;
import com.etiya.catalogservice.entities.ProductSpec;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OfferProductMapper {

    OfferProductMapper INSTANCE = Mappers.getMapper(OfferProductMapper.class);

    @Mapping(target = "offerId",source = "offer.id")
    @Mapping(target = "productId",source = "product.id")
    CreatedOfferProductResponseDto createOfferProductResponseDtoFromOfferProduct(OfferProduct offerProduct);

    @Mapping(target = "offerId",source = "offer.id")
    @Mapping(target = "productId",source = "product.id")
    GetOfferProductResponseDto getOfferProductResponseDtoFromOfferProduct(OfferProduct offerProduct);

    @Mapping(target = "offerId",source = "offer.id")
    @Mapping(target = "productId",source = "product.id")
    default List<ListOfferProductResponseDto> listOfferProductResponseDtoFromOfferProduct(List<OfferProduct> dtos){
        List<ListOfferProductResponseDto> responseDtos = dtos.stream().map(offerProduct ->
                new ListOfferProductResponseDto(offerProduct.getId(),offerProduct.getDescription(), offerProduct.getDiscountPercentage(),
                        offerProduct.getDescription(), offerProduct.getProduct().getId(), offerProduct.getOffer().getId())).toList();
        return responseDtos;
    }

    @Mapping(target = "offer.id",source = "offerId")
    @Mapping(target = "product.id",source = "productId")
    OfferProduct offerProductFromCreateOfferProductRequestDto(CreateOfferProductRequestDto dto);

    @Mapping(target = "offer.id",source = "offerId")
    @Mapping(target = "product.id",source = "productId")
    OfferProduct offerProductFromUpdateOfferProductRequestDto(UpdateOfferProductRequestDto dto);

    @Mapping(target = "offerId",source = "offer.id")
    @Mapping(target = "productId",source = "product.id")
    UpdatedOfferProductResponseDto updateOfferProductResponseDtoFromOfferProduct(OfferProduct dto);
}
