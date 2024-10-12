package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.dto.address.*;
import com.etiya.customerservice.entity.Address;
import com.etiya.customerservice.mapper.AddressMapper;
import com.etiya.customerservice.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl {
private final AddressRepository addressRepository;

    public List<ListAddressResponseDto> getAll() {
        List<Address> addressList = addressRepository.findAll();
        return AddressMapper.INSTANCE.listAddressResponseDtoFromAddressList(addressList);
    }
    public GetAddressResponseDto getById(UUID id) {
        Address address = addressRepository.findById(id).orElseThrow();
        return AddressMapper.INSTANCE.getAddressResponseDtoFromAddress(address);
    }
    public CreateAddressResponseDto save(CreateAddressRequestDto addressDto) {
        Address address = AddressMapper.INSTANCE.createAddressFromCreateAddressRequestDto(addressDto);
        addressRepository.save(address);
        return AddressMapper.INSTANCE.createAddressResponseDtoFromAddress(address);
    }
    public UpdateAddressResponseDto update(UpdateAddressRequestDto addressDto, UUID id) {
        Address address = AddressMapper.INSTANCE.addressFromUpdateAddressRequestDto(addressDto);
        address.setId(id);
        addressRepository.save(address);
        return AddressMapper.INSTANCE.updateAddressResponseDtoFromAddress(address);
    }
    public void delete(UUID id) {
        addressRepository.deleteById(id);
    }
}
