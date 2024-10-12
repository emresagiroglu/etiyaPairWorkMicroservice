package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.entity.Neighbourhood;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NeighbourhoodServiceImpl {
    private final NeighbourhoodRepository neighbourhoodRepository;

    public List<NeighbourhoodDto> getAll() {
        List<Neighbourhood> neighbourhoodList = neighbourhoodRepository.findAll();
        return NeighbourhoodMapper.INSTANCE.getAllNeighbourhoodDtoFromNeighbourhood(neighbourhoodList);
    }
    public NeighbourhoodDto getById(UUID id) {
        Neighbourhood neighbourhood = neighbourhoodRepository.findById(id).orElseThrow();
        return NeighbourhoodMapper.INSTANCE.getNeighbourhoodDtoFromNeighbourhood(neighbourhood);
    }
    public NeighbourhoodDto save(NeighbourhoodDto neighbourhoodDto) {
        Neighbourhood neighbourhood = NeighbourhoodMapper.INSTANCE.getNeighbourhoodFromNeighbourhoodDto(neighbourhoodDto);
        neighbourhoodRepository.save(neighbourhood);
        return NeighbourhoodMapper.INSTANCE.getNeighbourhoodDtoFromNeighbourhood(neighbourhood);
    }
    public NeighbourhoodDto update(NeighbourhoodDto neighbourhoodDto, UUID id) {
        Neighbourhood neighbourhood = NeighbourhoodMapper.INSTANCE.getNeighbourhoodFromNeighbourhoodDto(neighbourhoodDto);
        neighbourhood.setId(id);
        neighbourhoodRepository.save(neighbourhood);
        return NeighbourhoodMapper.INSTANCE.getNeighbourhoodDtoFromNeighbourhood(neighbourhood);
    }
    public void delete(UUID id) {
        neighbourhoodRepository.deleteById(id);
    }
}
