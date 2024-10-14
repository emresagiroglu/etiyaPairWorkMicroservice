package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.disctrict.GetDistrictResponseDto;
import com.etiya.customerservice.dto.neighbourhood.*;
import com.etiya.customerservice.entity.Neighbourhood;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NeighbourhoodMapper {
    NeighbourhoodMapper INSTANCE = Mappers.getMapper(NeighbourhoodMapper.class);
    @Mapping(source = "districtId", target = "district_id.id")
    Neighbourhood createNeighbourhoodFromCreateNeighbourhoodRequestDto(CreateNeighbourhoodRequestDto createNeighbourhoodRequestDto);
    @Mapping(source = "district_id.id", target = "districtId")
    CreateNeighbourhoodResponseDto createNeighbourhoodResponseDtoFromNeighbourhood(Neighbourhood neighbourhood);
    @Mapping(source = "district_id.id", target = "districtId")
    GetNeighbourhoodResponseDto getNeighbourhoodResponseDtoFromNeighbourhood(Neighbourhood neighbourhood);
    @Mapping(source = "district_id.id", target = "districtId")
    ListNeighbourhoodResponseDto listNeighbourhoodsResponseDtoFromNeighbourhoods(Neighbourhood neighbourhood);
    @Mapping(source = "district_id.id", target = "districtId")
    List<ListNeighbourhoodResponseDto> getAllNeighbourhoodsResponseDtoFromNeighbourhoods(List<Neighbourhood> neighbourhoods);
    @Mapping(source = "districtId", target = "district_id.id")
    Neighbourhood neighbourhoodFromUpdateRequestDto(UpdateNeighbourhoodRequestDto dto);
    @Mapping(source = "district_id.id", target = "districtId")
    UpdateNeighbourhoodResponseDto updateNeighbourhoodResponseDtoFromNeighbourhood(Neighbourhood neighbourhood);
}
