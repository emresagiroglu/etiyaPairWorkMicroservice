package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.address.*;
import com.etiya.customerservice.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address createAddressFromCreateAddressRequestDto(CreateAddressRequestDto createAddressRequestDto);
    CreateAddressResponseDto createAddressResponseDtoFromAddress(Address address);
    GetAddressResponseDto getAddressResponseDtoFromAddress(Address address);
    List<ListAddressResponseDto> listAddressResponseDtoFromAddressList(List<Address> addressList);
    UpdateAddressResponseDto updateAddressResponseDtoFromAddress(Address address);
    Address addressFromUpdateAddressRequestDto(UpdateAddressRequestDto updateAddressRequestDto);

}
