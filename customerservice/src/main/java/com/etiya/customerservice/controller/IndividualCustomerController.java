package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.individualcustomer.*;
import com.etiya.customerservice.services.abstracts.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin()
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
    public ResponseEntity<CreateIndividualCustomerResponseDto> createCustomer(@RequestBody @Valid CreateIndividualCustomerRequestDto createIndividualCustomerRequestDto)
    {
        CreateIndividualCustomerResponseDto createIndividualCustomerResponseDto = customerService.saveIndividualCustomer(createIndividualCustomerRequestDto);
        if (createIndividualCustomerResponseDto != null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(createIndividualCustomerResponseDto);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
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
