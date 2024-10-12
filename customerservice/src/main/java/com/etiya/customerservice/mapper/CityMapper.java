package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.city.CityDto;
import com.etiya.customerservice.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
    City getCityFromCityDto(CityDto cityDto);
    CityDto getCityDtoFromCity(City city);
    List<CityDto> getAllCityFromCityDto(List<City> cities);
}
