package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.dto.address.*;

import java.util.List;
import java.util.UUID;

public interface AddressService {
    List<ListAddressResponseDto> getAll();
    GetAddressResponseDto getById(UUID id);
    CreateAddressResponseDto save(CreateAddressRequestDto addressDto);
    UpdateAddressResponseDto update(UpdateAddressRequestDto addressDto, UUID id);
    void delete(UUID id);
}
