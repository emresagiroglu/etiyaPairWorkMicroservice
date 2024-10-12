package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.dto.neighbourhood.*;

import java.util.List;
import java.util.UUID;

public interface NeighbourhoodService {
    List<ListNeighbourhoodResponseDto> getAll();
    GetNeighbourhoodResponseDto getById(UUID id);
    CreateNeighbourhoodResponseDto save(CreateNeighbourhoodRequestDto createNeighbourhoodRequestDto);
    UpdateNeighbourhoodResponseDto update(UpdateNeighbourhoodRequestDto updateNeighbourhoodRequestDto, UUID id);
    void delete(UUID id);
}
