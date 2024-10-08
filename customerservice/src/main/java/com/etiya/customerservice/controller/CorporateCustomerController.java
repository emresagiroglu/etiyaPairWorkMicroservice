package com.etiya.customerservice.controller;

import com.etiya.customerservice.services.abstracts.CorporateCustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers/corporate")
public class CorporateCustomerController {

    private final CorporateCustomerService corporateCustomerService;


    @GetMapping()
    public String hello(){
        return "Hi from Corporate Customer Service";
    }
}
