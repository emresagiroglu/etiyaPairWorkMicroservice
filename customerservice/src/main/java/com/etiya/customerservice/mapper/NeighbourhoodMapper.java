package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.disctrict.GetDistrictResponseDto;
import com.etiya.customerservice.dto.neighbourhood.*;
import com.etiya.customerservice.entity.Neighbourhood;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NeighbourhoodMapper {
    NeighbourhoodMapper INSTANCE = Mappers.getMapper(NeighbourhoodMapper.class);
    Neighbourhood createNeighbourhoodFromCreateNeighbourhoodRequestDto(CreateNeighbourhoodRequestDto createNeighbourhoodRequestDto);
    CreateNeighbourhoodResponseDto createNeighbourhoodResponseDtoFromNeighbourhood(Neighbourhood neighbourhood);
    GetNeighbourhoodResponseDto getNeighbourhoodResponseDtoFromNeighbourhood(Neighbourhood neighbourhood);
    List<ListNeighbourhoodResponseDto> getAllNeighbourhoodsResponseDtoFromNeighbourhoods(List<Neighbourhood> neighbourhoods);
    Neighbourhood neighbourhoodFromUpdateRequestDto(UpdateNeighbourhoodRequestDto dto);
    UpdateNeighbourhoodResponseDto updateNeighbourhoodResponseDtoFromNeighbourhood(Neighbourhood neighbourhood);
}
