package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.disctrict.*;
import com.etiya.customerservice.entity.District;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DistrictMapper {
   DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);

   @Mapping(source = "cityId", target = "city_id.id")
   District createDistrictFromCreateDistrictRequestDto(CreateDistrictRequestDto createDistrictRequestDto);
   @Mapping(source = "city_id.id", target = "cityId")
   CreateDistrictResponseDto createDistrictResponseDtoFromDistrict(District district);
   @Mapping(source = "city_id.id", target = "cityId")
   GetDistrictResponseDto getDistrictResponseDtoFromDistrict(District district);
   @Mapping(source = "city_id.id", target = "cityId")
   ListDistrictResponseDto listDistrictsResponseDtoFromDistricts(District district);
   @Mapping(source = "city_id.id", target = "cityId")
   List<ListDistrictResponseDto> getAllDistrictsResponseDtoFromDistricts(List<District> districts);
   @Mapping(source = "cityId", target = "city_id.id")
   District districtFromUpdateRequestDto(UpdateDistrictRequestDto updateDistrictRequestDto);
   @Mapping(source = "city_id.id", target = "cityId")
   UpdateDistrictResponseDto updateDistrictResponseDtoFromDistrict(District district);
}
