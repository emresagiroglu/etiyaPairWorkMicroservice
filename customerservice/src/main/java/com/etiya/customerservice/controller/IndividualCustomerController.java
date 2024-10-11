package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.corporatecustomer.*;
import com.etiya.customerservice.dto.individualcustomer.*;
import com.etiya.customerservice.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers/individual")
public class IndividualCustomerController {

    private final CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<ListIndividualCustomerResponseDto>> getAll()
    {
        return ResponseEntity.ok(customerService.getIndividualCustomersAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetIndividualCustomerResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(customerService.getIndividualCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<CreateIndividualCustomerResponseDto> createCustomer(@RequestBody CreateIndividualCustomerRequestDto createIndividualCustomerRequestDto)
    {
        return ResponseEntity.ok(customerService.saveIndividualCustomer(createIndividualCustomerRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateIndividualCustomerResponseDto> updateIndividualCustomer(
            @PathVariable UUID id,
            @RequestBody UpdateIndividualCustomerRequestDto updateIndividualCustomerRequestDto)
    {
        return ResponseEntity.ok(customerService.updateIndividualCustomer(updateIndividualCustomerRequestDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIndividualCustomer(@PathVariable UUID id)
    {
        customerService.deleteIndividualCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
