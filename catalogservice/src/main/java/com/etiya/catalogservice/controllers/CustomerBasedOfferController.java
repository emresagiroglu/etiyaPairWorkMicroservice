package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.dtos.customerBasedOffer.*;
import com.etiya.catalogservice.services.abstracts.CustomerBasedOfferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalogs/customerBasedOffers")
public class CustomerBasedOfferController {

    private final CustomerBasedOfferService customerBasedOfferService;

    @PostMapping
    public ResponseEntity<CreatedCustomerBasedOfferResponseDto> add(@Valid @RequestBody CreateCustomerBasedOfferRequestDto createCustomerBasedOfferRequest){
        return ResponseEntity.ok(customerBasedOfferService.add(createCustomerBasedOfferRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCustomerBasedOfferResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(customerBasedOfferService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ListCustomerBasedOfferResponseDto>> getAll()
    {
        return ResponseEntity.ok(customerBasedOfferService.getAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<UpdatedCustomerBasedOfferResponseDto> update(@PathVariable UUID id, @RequestBody UpdateCustomerBasedOfferRequestDto request)
    {
        return ResponseEntity.ok(customerBasedOfferService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id)
    {
        customerBasedOfferService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
