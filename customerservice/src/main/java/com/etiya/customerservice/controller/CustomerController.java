package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.customer.GetCustomerResponseDto;
import com.etiya.customerservice.dto.individualcustomer.GetIndividualCustomerResponseDto;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.services.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<GetCustomerResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
}
