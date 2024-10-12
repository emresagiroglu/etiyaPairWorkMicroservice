package com.etiya.customerservice.services.abstracts;

public interface DistrictService {
    List<DistrictDto> getAll();
    DistrictDto getById(UUID id);
    DistrictDto save(DistrictDto districtDto);
    DistrictDto update(DistrictDto districtDto, UUID id);
    void delete(UUID id);
}
