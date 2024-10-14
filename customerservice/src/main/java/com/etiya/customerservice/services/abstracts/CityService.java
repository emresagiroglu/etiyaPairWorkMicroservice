package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.dto.city.CityDto;

import java.util.List;


public interface CityService {
    List<CityDto> getAll();
    CityDto getById(Long id);
    CityDto save(CityDto cityDto);
    CityDto update(CityDto cityDto, Long id);
    void delete(Long id);
}
