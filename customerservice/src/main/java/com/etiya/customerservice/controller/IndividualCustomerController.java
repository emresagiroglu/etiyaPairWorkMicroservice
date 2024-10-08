package com.etiya.customerservice.controller;

import com.etiya.customerservice.services.abstracts.IndividualCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/individual-customers")
public class IndividualCustomerController {

    private final IndividualCustomerService individualCustomerService;

    @Autowired
    public IndividualCustomerController(IndividualCustomerService individualCustomerService)
    {
        this.individualCustomerService = individualCustomerService;
    }
    @GetMapping()
    public String hello(){
        return "Hi from Individual Customer Service";
    }
}
