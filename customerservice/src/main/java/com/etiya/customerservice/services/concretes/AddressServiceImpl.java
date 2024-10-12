package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl {
private final AddressRepository addressRepository;

    public List<AddressDto> getAll() {
        List<Address> addressList = addressRepository.findAll();
        return AddressMapper.INSTANCE.getAllAddressDtoFromAddress(addressList);
    }
    public AddressDto getById(UUID id) {
        Address address = addressRepository.findById(id).orElseThrow();
        return AddressMapper.INSTANCE.getAddressDtoFromAddress(address);
    }
    public AddressDto save(AddressDto addressDto) {
        Address address = AddressMapper.INSTANCE.getAddressFromAddressDto(addressDto);
        addressRepository.save(address);
        return AddressMapper.INSTANCE.getAddressDtoFromAddress(address);
    }
    public AddressDto update(AddressDto addressDto, UUID id) {
        Address address = AddressMapper.INSTANCE.getAddressFromAddressDto(addressDto);
        address.setId(id);
        addressRepository.save(address);
        return AddressMapper.INSTANCE.getAddressDtoFromAddress(address);
    }
    public void delete(UUID id) {
        addressRepository.deleteById(id);
    }
}
