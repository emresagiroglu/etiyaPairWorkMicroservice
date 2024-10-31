package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.dto.city.CityRequestDto;
import com.etiya.customerservice.dto.city.CityResponseDto;
import com.etiya.customerservice.entity.City;
import com.etiya.customerservice.mapper.CityMapper;
import com.etiya.customerservice.repositories.CityRepository;
import com.etiya.customerservice.services.abstracts.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public List<CityResponseDto> getAll() {
        List<City> cityList = cityRepository.findAll();
        return CityMapper.INSTANCE.getAllCityResponseDtoFromCityDto(cityList);
    }
    public CityResponseDto getById(Long id) {
        City city = cityRepository.findById(id).orElseThrow();
        return CityMapper.INSTANCE.getCityResponseDtoFromCity(city);
    }
    public CityResponseDto save(CityRequestDto cityDto) {
        City city = CityMapper.INSTANCE.getCityFromCityRequestDto(cityDto);
        cityRepository.save(city);
        return CityMapper.INSTANCE.getCityResponseDtoFromCity(city);
    }
    public CityResponseDto update(CityRequestDto cityDto, Long id) {
        City city = CityMapper.INSTANCE.getCityFromCityRequestDto(cityDto);
        city.setId(id);
        cityRepository.save(city);
        return CityMapper.INSTANCE.getCityResponseDtoFromCity(city);
    }
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

}
