package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.dto.disctrict.*;
import com.etiya.customerservice.dto.neighbourhood.UpdateNeighbourhoodResponseDto;
import com.etiya.customerservice.entity.District;

import java.util.List;
import java.util.UUID;

public interface DistrictService {
    List<ListDistrictResponseDto> getAll();
    GetDistrictResponseDto getById(UUID id);
    CreateDistrictResponseDto save(CreateDistrictRequestDto createDistrictRequestDto);
    UpdateDistrictResponseDto update(UpdateDistrictRequestDto updateDistrictRequestDto, UUID id);
    void delete(UUID id);
}
