package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.address.*;
import com.etiya.customerservice.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "customerId" ,target = "customerId.id" )
    @Mapping(source = "neighbourhoodId" ,target = "neighbourhoodId.id" )
    Address createAddressFromCreateAddressRequestDto(CreateAddressRequestDto createAddressRequestDto);
    @Mapping(source = "customerId.id" , target = "customerId")
    @Mapping(source = "neighbourhoodId.id" , target = "neighbourhoodId")
    CreateAddressResponseDto createAddressResponseDtoFromAddress(Address address);
    @Mapping(source = "customerId.id" , target = "customerId")
    @Mapping(source = "neighbourhoodId.id" , target = "neighbourhoodId")
    GetAddressResponseDto getAddressResponseDtoFromAddress(Address address);
    @Mapping(source = "customerId.id" , target = "customerId")
    @Mapping(source = "neighbourhoodId.id" , target = "neighbourhoodId")
    ListAddressResponseDto addressToListAddressResponseDto(Address address);
    @Mapping(source = "customerId.id" , target = "customerId")
    @Mapping(source = "neighbourhoodId.id" , target = "neighbourhoodId")
    List<ListAddressResponseDto> listAddressResponseDtoFromAddressList(List<Address> addressList);
    @Mapping(source = "customerId.id" , target = "customerId")
    @Mapping(source = "neighbourhoodId.id" , target = "neighbourhoodId")
    UpdateAddressResponseDto updateAddressResponseDtoFromAddress(Address address);
    @Mapping(source = "customerId" ,target = "customerId.id" )
    @Mapping(source = "neighbourhoodId" ,target = "neighbourhoodId.id" )
    Address addressFromUpdateAddressRequestDto(UpdateAddressRequestDto updateAddressRequestDto);

}
