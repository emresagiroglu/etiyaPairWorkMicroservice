package com.etiya.customerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/corporate-customers")
public class CorporateCustomerController {

    @GetMapping()
    public String hello(){
        return "Hi from Corporate Customer Service";
    }
}
