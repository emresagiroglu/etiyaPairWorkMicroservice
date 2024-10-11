package com.etiya.customerservice.controller;

import com.etiya.customerservice.entity.CorporateCustomer;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.services.abstracts.IndividualCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers/individual")
public class IndividualCustomerController {

    private final IndividualCustomerService individualCustomerService;

    @GetMapping("/{id}")
    public ResponseEntity<IndividualCustomer> getById(@PathVariable UUID id){
        return ResponseEntity.ok(individualCustomerService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<IndividualCustomer>> getAll()
    {
        return ResponseEntity.ok(individualCustomerService.getAll());
    }

}
