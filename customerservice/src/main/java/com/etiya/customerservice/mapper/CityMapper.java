package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.city.CityRequestDto;
import com.etiya.customerservice.dto.city.CityResponseDto;
import com.etiya.customerservice.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
    City getCityFromCityRequestDto(CityRequestDto cityDto);
    CityResponseDto getCityResponseDtoFromCity(City city);
    List<CityResponseDto> getAllCityResponseDtoFromCityDto(List<City> cities);
}
