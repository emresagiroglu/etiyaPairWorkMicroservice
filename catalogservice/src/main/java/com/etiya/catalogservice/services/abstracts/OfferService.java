package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.dtos.offer.*;

import java.util.List;
import java.util.UUID;

public interface OfferService {

    CreatedOfferResponseDto add(CreateOfferRequestDto createOfferRequestDto);

    GetOfferResponseDto getById(UUID id);

    List<ListOfferResponseDto> getAll();

    UpdatedOfferResponseDto update(UUID id, UpdateOfferRequestDto updateOfferRequestDto);

    void delete(UUID id);

}
