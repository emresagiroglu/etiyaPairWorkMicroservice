package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.individualcustomer.*;
import com.etiya.customerservice.services.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public ResponseEntity<GetIndividualCustomerResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getIndividualCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<CreateIndividualCustomerResponseDto> createCustomer(@RequestBody CreateIndividualCustomerRequestDto createIndividualCustomerRequestDto)
    {
        return ResponseEntity.ok(customerService.saveIndividualCustomer(createIndividualCustomerRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateIndividualCustomerResponseDto> updateIndividualCustomer(
            @PathVariable Long id,
            @RequestBody UpdateIndividualCustomerRequestDto updateIndividualCustomerRequestDto)
    {
        return ResponseEntity.ok(customerService.updateIndividualCustomer(updateIndividualCustomerRequestDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIndividualCustomer(@PathVariable Long id)
    {
        customerService.deleteIndividualCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
