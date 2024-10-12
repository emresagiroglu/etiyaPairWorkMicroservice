package com.etiya.customerservice.services.abstracts;

public interface AddressService {
    List<AddressDto> getAll();
    AddressDto getById(UUID id);
    AddressDto save(AddressDto addressDto);
    AddressDto update(AddressDto addressDto, UUID id);
    void delete(UUID id);
}
