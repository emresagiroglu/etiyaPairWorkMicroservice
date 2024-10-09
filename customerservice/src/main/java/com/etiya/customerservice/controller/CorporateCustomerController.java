package com.etiya.customerservice.controller;

import com.etiya.customerservice.services.abstracts.CorporateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers/corporate")
public class CorporateCustomerController {

    private final CorporateCustomerService corporateCustomerService;

    @Autowired
    public CorporateCustomerController(CorporateCustomerService corporateCustomerService)
    {
        this.corporateCustomerService = corporateCustomerService;
    }

    @GetMapping()
    public String hello(){
        return "Hi from Corporate Customer Service";
    }
}
