package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.dtos.offerProduct.*;
import com.etiya.catalogservice.entities.Offer;
import com.etiya.catalogservice.entities.OfferProduct;
import com.etiya.catalogservice.entities.Product;
import com.etiya.catalogservice.mappers.OfferProductMapper;
import com.etiya.catalogservice.repositories.OfferProductRepository;
import com.etiya.catalogservice.services.abstracts.OfferProductService;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OfferProductServiceImpl implements OfferProductService {


    private final OfferProductRepository offerProductRepository;

    @Override
    public CreatedOfferProductResponseDto add(CreateOfferProductRequestDto createOfferProductRequest) {
        OfferProduct offerProduct = OfferProductMapper.INSTANCE.offerProductFromCreateOfferProductRequestDto(createOfferProductRequest);
        OfferProduct createdOfferProduct = offerProductRepository.save(offerProduct);

        CreatedOfferProductResponseDto response =
                OfferProductMapper.INSTANCE.createOfferProductResponseDtoFromOfferProduct(createdOfferProduct);


        return response;
    }

    @Override
    public GetOfferProductResponseDto getById(UUID id) {
        OfferProduct offerProduct = offerProductRepository.findById(id).orElseThrow();

        GetOfferProductResponseDto response =
                OfferProductMapper.INSTANCE.getOfferProductResponseDtoFromOfferProduct(offerProduct);

        return response;
    }

    @Override
    public List<ListOfferProductResponseDto> getAll() {
        List<OfferProduct> offerProductList = offerProductRepository.findAll();
        List<ListOfferProductResponseDto> getAllOfferProductResponseList = OfferProductMapper.INSTANCE.listOfferProductResponseDtoFromOfferProduct(offerProductList);

        return getAllOfferProductResponseList;
    }

    @Override
    public UpdatedOfferProductResponseDto update(UUID id, UpdateOfferProductRequestDto updateOfferProductRequestDto) {
        OfferProduct offerProduct = offerProductRepository.findById(id).orElseThrow();

        offerProduct.setDescription(updateOfferProductRequestDto.getDescription());
        offerProduct.setDiscountDesc(updateOfferProductRequestDto.getDiscountDesc());
        offerProduct.setDiscountPercentage(updateOfferProductRequestDto.getDiscountPercentage());

        //OfferProduct içindeki update offer ve update product işlemi sonra yapılacak!

        offerProductRepository.save(offerProduct);

        UpdatedOfferProductResponseDto response = OfferProductMapper.INSTANCE.updateOfferProductResponseDtoFromOfferProduct(offerProduct);

        return response;
    }

    @Override
    public void delete(UUID id) {
        offerProductRepository.deleteById(id);
    }

}

