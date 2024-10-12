package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.dto.city.CityDto;

import java.util.List;
import java.util.UUID;

public interface CityService {
    List<CityDto> getAll();
    CityDto getById(UUID id);
    CityDto save(CityDto cityDto);
    CityDto update(CityDto cityDto, UUID id);
    void delete(UUID id);
}
