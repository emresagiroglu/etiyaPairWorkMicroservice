package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.entity.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CityServiceImpl {
    private final CityRepository cityRepository;

    public List<CityDto> getAll() {
        List<City> cityList = cityRepository.findAll();
        return CityMapper.INSTANCE.getAllCityDtoFromCity(cityList);
    }
    public CityDto getById(UUID id) {
        City city = cityRepository.findById(id).orElseThrow();
        return CityMapper.INSTANCE.getCityDtoFromCity(city);
    }
    public CityDto save(CityDto cityDto) {
        City city = CityMapper.INSTANCE.getCityFromCityDto(cityDto);
        cityRepository.save(city);
        return CityMapper.INSTANCE.getCityDtoFromCity(city);
    }
    public CityDto update(CityDto cityDto, UUID id) {
        City city = CityMapper.INSTANCE.getCityFromCityDto(cityDto);
        city.setId(id);
        cityRepository.save(city);
        return CityMapper.INSTANCE.getCityDtoFromCity(city);
    }
    public void delete(UUID id) {
        cityRepository.deleteById(id);
    }

}
