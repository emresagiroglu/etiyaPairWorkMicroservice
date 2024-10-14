package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.dto.city.CityDto;
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

    public List<CityDto> getAll() {
        List<City> cityList = cityRepository.findAll();
        return CityMapper.INSTANCE.getAllCityFromCityDto(cityList);
    }
    public CityDto getById(Long id) {
        City city = cityRepository.findById(id).orElseThrow();
        return CityMapper.INSTANCE.getCityDtoFromCity(city);
    }
    public CityDto save(CityDto cityDto) {
        City city = CityMapper.INSTANCE.getCityFromCityDto(cityDto);
        cityRepository.save(city);
        return CityMapper.INSTANCE.getCityDtoFromCity(city);
    }
    public CityDto update(CityDto cityDto, Long id) {
        City city = CityMapper.INSTANCE.getCityFromCityDto(cityDto);
        city.setId(id);
        cityRepository.save(city);
        return CityMapper.INSTANCE.getCityDtoFromCity(city);
    }
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

}
