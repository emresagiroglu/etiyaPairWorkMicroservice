package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.corpatecustomer.CreateCorporateCustomerRequestDto;
import com.etiya.customerservice.dto.corpatecustomer.CreateCorporateCustomerResponseDto;
import com.etiya.customerservice.dto.corpatecustomer.GetCorporateCustomerResponseDto;
import com.etiya.customerservice.dto.corpatecustomer.ListCorporateCustomerResponseDto;
import com.etiya.customerservice.entity.CorporateCustomer;
import com.etiya.customerservice.services.abstracts.CorporateCustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers/corporate")
public class CorporateCustomerController {

    private final CorporateCustomerService corporateCustomerService;

    @GetMapping("/{id}")
    public ResponseEntity<GetCorporateCustomerResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(corporateCustomerService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ListCorporateCustomerResponseDto>> getAll()
    {
        return ResponseEntity.ok(corporateCustomerService.getAll());
    }

    @PostMapping
    public CreateCorporateCustomerResponseDto createCustomer(@RequestBody CreateCorporateCustomerRequestDto createCorporateCustomerRequestDto)
    {
        CreateCorporateCustomerResponseDto createCorporateCustomerResponseDto = corporateCustomerService.save(createCorporateCustomerRequestDto);
        return createCorporateCustomerResponseDto;
    }


}
