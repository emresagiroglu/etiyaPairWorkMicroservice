package com.etiya.customerservice.services.abstracts;

public interface CityService {
    List<CityDto> getAll();
    CityDto getById(UUID id);
    CityDto save(CityDto cityDto);
    CityDto update(CityDto cityDto, UUID id);
    void delete(UUID id);
}
