package com.etiya.customerservice.services.abstracts;

public interface NeighbourhoodService {
    List<NeighbourhoodDto> getAll();
    NeighbourhoodDto getById(UUID id);
    NeighbourhoodDto save(NeighbourhoodDto neighbourhoodDto);
    NeighbourhoodDto update(NeighbourhoodDto neighbourhoodDto, UUID id);
    void delete(UUID id);
}
