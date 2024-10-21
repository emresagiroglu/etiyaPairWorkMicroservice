package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.address.*;
import com.etiya.customerservice.services.abstracts.AddressService;
import com.netflix.discovery.converters.Auto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers/addresses")
public class AddressController {

    private final AddressService addressService;
    @GetMapping()
    public ResponseEntity<List<ListAddressResponseDto>> getAll()
    {
        return ResponseEntity.ok(addressService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetAddressResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.getById(id));
    }
    @PostMapping
    public ResponseEntity<CreateAddressResponseDto> createAddress(@RequestBody @Valid CreateAddressRequestDto addressDto)
    {
        return ResponseEntity.ok(addressService.save(addressDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateAddressResponseDto> updateAddress(
            @PathVariable Long id,
            @RequestBody UpdateAddressRequestDto addressDto)
    {
        return ResponseEntity.ok(addressService.update(addressDto,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id)
    {
        addressService.delete(id);
        return ResponseEntity.ok().build();
    }
}
