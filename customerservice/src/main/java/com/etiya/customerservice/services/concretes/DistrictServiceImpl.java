package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.entity.District;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl {
    private final DistrictRepository districtRepository;

    public List<DistrictDto> getAll() {
        List<District> districtList = districtRepository.findAll();
        return DistrictMapper.INSTANCE.getAllDistrictDtoFromDistrict(districtList);
    }
    public DistrictDto getById(UUID id) {
        District district = districtRepository.findById(id).orElseThrow();
        return DistrictMapper.INSTANCE.getDistrictDtoFromDistrict(district);
    }
    public DistrictDto save(DistrictDto districtDto) {
        District district = DistrictMapper.INSTANCE.getDistrictFromDistrictDto(districtDto);
        districtRepository.save(district);
        return DistrictMapper.INSTANCE.getDistrictDtoFromDistrict(district);
    }
    public DistrictDto update(DistrictDto districtDto, UUID id) {
        District district = DistrictMapper.INSTANCE.getDistrictFromDistrictDto(districtDto);
        district.setId(id);
        districtRepository.save(district);
        return DistrictMapper.INSTANCE.getDistrictDtoFromDistrict(district);
    }
    public void delete(UUID id) {
        districtRepository.deleteById(id);
    }
}
