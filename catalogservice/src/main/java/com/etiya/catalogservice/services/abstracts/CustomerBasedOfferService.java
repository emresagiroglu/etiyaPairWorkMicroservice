package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.dtos.customerBasedOffer.*;

import java.util.List;
import java.util.UUID;

public interface CustomerBasedOfferService {

    CreatedCustomerBasedOfferResponseDto add(CreateCustomerBasedOfferRequestDto createCustomerBasedOfferRequestDto);

    GetCustomerBasedOfferResponseDto getById(UUID id);

    List<ListCustomerBasedOfferResponseDto> getAll();

    UpdatedCustomerBasedOfferResponseDto update(UUID id, UpdateCustomerBasedOfferRequestDto updateCustomerBasedOfferRequestDto);

    void delete(UUID id);

}
