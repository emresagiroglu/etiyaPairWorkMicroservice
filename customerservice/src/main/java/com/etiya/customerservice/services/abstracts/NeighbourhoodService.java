package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.dto.neighbourhood.*;

import java.util.List;


public interface NeighbourhoodService {
    List<ListNeighbourhoodResponseDto> getAll();
    GetNeighbourhoodResponseDto getById(Long id);
    CreateNeighbourhoodResponseDto save(CreateNeighbourhoodRequestDto createNeighbourhoodRequestDto);
    UpdateNeighbourhoodResponseDto update(UpdateNeighbourhoodRequestDto updateNeighbourhoodRequestDto, Long id);
    void delete(Long id);
}
