package com.etiya.customerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/individual-customers")
public class IndividualCustomerController {
    @GetMapping()
    public String hello(){
        return "Hi from Individual Customer Service";
    }
}
