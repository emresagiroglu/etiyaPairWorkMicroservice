package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.dtos.offerProduct.*;

import java.util.List;
import java.util.UUID;

public interface OfferProductService {

    CreatedOfferProductResponseDto add(CreateOfferProductRequestDto createOfferProductRequestDto);

    GetOfferProductResponseDto getById(UUID id);

    List<ListOfferProductResponseDto> getAll();

    UpdatedOfferProductResponseDto update(UUID id, UpdateOfferProductRequestDto updateOfferProductRequestDto);

    void delete(UUID id);

}
