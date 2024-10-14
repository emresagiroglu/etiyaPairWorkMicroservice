package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.dto.disctrict.*;
import com.etiya.customerservice.entity.District;
import com.etiya.customerservice.mapper.DistrictMapper;
import com.etiya.customerservice.repositories.DistrictRepository;
import com.etiya.customerservice.services.abstracts.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;

    public List<ListDistrictResponseDto> getAll() {
        List<District> districtList = districtRepository.findAll();
        return DistrictMapper.INSTANCE.getAllDistrictsResponseDtoFromDistricts(districtList);
    }
    public GetDistrictResponseDto getById(Long id) {
        District district = districtRepository.findById(id).orElseThrow();
        return DistrictMapper.INSTANCE.getDistrictResponseDtoFromDistrict(district);
    }
    public CreateDistrictResponseDto save(CreateDistrictRequestDto createDistrictRequestDto) {
        District district = DistrictMapper.INSTANCE.createDistrictFromCreateDistrictRequestDto(createDistrictRequestDto);
        districtRepository.save(district);
        return DistrictMapper.INSTANCE.createDistrictResponseDtoFromDistrict(district);
    }
    public UpdateDistrictResponseDto update(UpdateDistrictRequestDto updateDistrictRequestDto, Long id) {
        District district = DistrictMapper.INSTANCE.districtFromUpdateRequestDto(updateDistrictRequestDto);
        district.setId(id);
        districtRepository.save(district);
        return DistrictMapper.INSTANCE.updateDistrictResponseDtoFromDistrict(district);
    }
    public void delete(Long id) {
        districtRepository.deleteById(id);
    }
}
