package com.etiya.customerservice.controller;

import com.etiya.customerservice.services.abstracts.IndividualCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers/individual")
public class IndividualCustomerController {

    private final IndividualCustomerService individualCustomerService;


    @GetMapping()
    public String hello(){
        return "Hi from Individual Customer Service";
    }
}
