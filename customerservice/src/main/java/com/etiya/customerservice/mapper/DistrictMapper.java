package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.disctrict.*;
import com.etiya.customerservice.entity.District;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DistrictMapper {
   DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);

   District createDistrictFromCreateDistrictRequestDto(CreateDistrictRequestDto createDistrictRequestDto);
   CreateDistrictResponseDto createDistrictResponseDtoFromDistrict(District district);
   GetDistrictResponseDto getDistrictResponseDtoFromDistrict(District district);
   List<ListDistrictResponseDto> getAllDistrictsResponseDtoFromDistricts(List<District> districts);
   District districtFromUpdateRequestDto(UpdateDistrictRequestDto updateDistrictRequestDto);
   UpdateDistrictResponseDto updateDistrictResponseDtoFromDistrict(District district);
}
