package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.dto.disctrict.*;
import com.etiya.customerservice.dto.neighbourhood.UpdateNeighbourhoodResponseDto;
import com.etiya.customerservice.entity.District;

import java.util.List;


public interface DistrictService {
    List<ListDistrictResponseDto> getAll();
    GetDistrictResponseDto getById(Long id);
    CreateDistrictResponseDto save(CreateDistrictRequestDto createDistrictRequestDto);
    UpdateDistrictResponseDto update(UpdateDistrictRequestDto updateDistrictRequestDto, Long id);
    void delete(Long id);
}
