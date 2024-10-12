package com.etiya.customerservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addresses")
public class AddressController {
    private final AddressService addressService;
    @GetMapping()
    public ResponseEntity<List<AddressDto>> getAll()
    {
        return ResponseEntity.ok(addressService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(addressService.getById(id));
    }
    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto)
    {
        return ResponseEntity.ok(addressService.save(addressDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AddressDto> updateAddress(
            @PathVariable UUID id,
            @RequestBody AddressDto addressDto)
    {
        return ResponseEntity.ok(addressService.update(addressDto,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable UUID id)
    {
        addressService.delete(id);
        return ResponseEntity.ok().build();
    }
}
