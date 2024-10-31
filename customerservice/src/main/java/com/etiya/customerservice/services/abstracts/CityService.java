package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.dto.city.CityRequestDto;
import com.etiya.customerservice.dto.city.CityResponseDto;

import java.util.List;


public interface CityService {
    List<CityResponseDto> getAll();
    CityResponseDto getById(Long id);
    CityResponseDto save(CityRequestDto cityDto);
    CityResponseDto update(CityRequestDto cityDto, Long id);
    void delete(Long id);
}
