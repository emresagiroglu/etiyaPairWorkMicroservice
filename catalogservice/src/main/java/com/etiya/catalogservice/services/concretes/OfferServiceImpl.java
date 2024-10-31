package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.core.exception.type.BusinessException;
import com.etiya.catalogservice.dtos.offer.*;
import com.etiya.catalogservice.entities.Offer;
import com.etiya.catalogservice.mappers.OfferMapper;
import com.etiya.catalogservice.repositories.OfferRepository;
import com.etiya.catalogservice.services.abstracts.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;



@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {


    private final OfferRepository offerRepository;

    @Override
    public CreatedOfferResponseDto add(CreateOfferRequestDto createOfferRequest) {
        Offer offer = OfferMapper.INSTANCE.offerFromCreateOfferRequestDto(createOfferRequest);
        Offer createdOffer = offerRepository.save(offer);

        CreatedOfferResponseDto response =
                OfferMapper.INSTANCE.createOfferResponseDtoFromOffer(createdOffer);


        return response;
    }

    @Override
    public GetOfferResponseDto getById(UUID id) {
        Offer offer = offerRepository.findById(id).orElseThrow();

        GetOfferResponseDto response =
                OfferMapper.INSTANCE.getOfferResponseDtoFromOffer(offer);

        return response;
    }

    @Override
    public List<ListOfferResponseDto> getAll() {
        List<Offer> offerList = offerRepository.findAllByIsActiveTrue()
                .orElseThrow(() -> new BusinessException("There is no active Offers"));
        List<ListOfferResponseDto> getAllOfferResponseList = OfferMapper.INSTANCE.listOfferResponseDtoFromOffer(offerList);

        return getAllOfferResponseList;
    }

    @Override
    public UpdatedOfferResponseDto update(UUID id, UpdateOfferRequestDto updateOfferRequestDto) {
        Offer offer = offerRepository.findById(id).orElseThrow();

        offer.setName(updateOfferRequestDto.getName());
        offer.setStartDate(updateOfferRequestDto.getStartDate());
        offer.setEndDate(updateOfferRequestDto.getEndDate());

        offerRepository.save(offer);

        UpdatedOfferResponseDto response = OfferMapper.INSTANCE.updateOfferResponseDtoFromOffer(offer);

        return response;
    }

    @Override
    public void delete(UUID id) {
        Offer offer = offerRepository.
                findByIdAndIsActiveTrue(id).
                orElseThrow(() -> new BusinessException("There is no active Offer with this id: " + id));
        offer.setIsActive(false);
        offerRepository.save(offer);
    }

    @Override
    public Offer findById(UUID id) {
        return offerRepository.
                findByIdAndIsActiveTrue(id).
                orElseThrow(() -> new BusinessException("There is no active Offer with this id: " + id));
    }

}
