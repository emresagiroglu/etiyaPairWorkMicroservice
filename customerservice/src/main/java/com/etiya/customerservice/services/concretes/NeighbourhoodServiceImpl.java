package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.dto.neighbourhood.*;
import com.etiya.customerservice.entity.Neighbourhood;
import com.etiya.customerservice.mapper.NeighbourhoodMapper;
import com.etiya.customerservice.repositories.NeighbourhoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NeighbourhoodServiceImpl {
    private final NeighbourhoodRepository neighbourhoodRepository;

    public List<ListNeighbourhoodResponseDto> getAll() {
        List<Neighbourhood> neighbourhoodList = neighbourhoodRepository.findAll();
        return NeighbourhoodMapper.INSTANCE.getAllNeighbourhoodsResponseDtoFromNeighbourhoods(neighbourhoodList);
    }
    public GetNeighbourhoodResponseDto getById(UUID id) {
        Neighbourhood neighbourhood = neighbourhoodRepository.findById(id).orElseThrow();
        return NeighbourhoodMapper.INSTANCE.getNeighbourhoodResponseDtoFromNeighbourhood(neighbourhood);
    }
    public CreateNeighbourhoodResponseDto save(CreateNeighbourhoodRequestDto neighbourhoodDto) {
        Neighbourhood neighbourhood = NeighbourhoodMapper.INSTANCE.createNeighbourhoodFromCreateNeighbourhoodRequestDto(neighbourhoodDto);
        neighbourhoodRepository.save(neighbourhood);
        return NeighbourhoodMapper.INSTANCE.createNeighbourhoodResponseDtoFromNeighbourhood(neighbourhood);
    }
    public UpdateNeighbourhoodResponseDto update(UpdateNeighbourhoodRequestDto neighbourhoodDto, UUID id) {
        Neighbourhood neighbourhood = NeighbourhoodMapper.INSTANCE.neighbourhoodFromUpdateRequestDto(neighbourhoodDto);
        neighbourhood.setId(id);
        neighbourhoodRepository.save(neighbourhood);
        return NeighbourhoodMapper.INSTANCE.updateNeighbourhoodResponseDtoFromNeighbourhood(neighbourhood);
    }
    public void delete(UUID id) {
        neighbourhoodRepository.deleteById(id);
    }
}
