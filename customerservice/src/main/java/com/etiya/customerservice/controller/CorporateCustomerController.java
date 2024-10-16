package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.corporatecustomer.*;
import com.etiya.customerservice.services.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers/corporate")
public class CorporateCustomerController {

    private final CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<ListCorporateCustomerResponseDto>> getAll()
    {
        return ResponseEntity.ok(customerService.getCorporateCustomersAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCorporateCustomerResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCorporateCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<CreateCorporateCustomerResponseDto> createCustomer(@RequestBody CreateCorporateCustomerRequestDto createCorporateCustomerRequestDto)
    {
        return ResponseEntity.ok(customerService.saveCorporateCustomer(createCorporateCustomerRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCorporateCustomerResponseDto> updateCorporateCustomer(
            @PathVariable Long id,
            @RequestBody UpdateCorporateCustomerRequestDto updateCorporateCustomerRequestDto)
    {
        return ResponseEntity.ok(customerService.updateCorporateCustomer(updateCorporateCustomerRequestDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCorporateCustomer(@PathVariable Long id)
    {
         customerService.deleteCorporateCustomer(id);
         return new ResponseEntity<>(HttpStatus.OK);
    }

}
