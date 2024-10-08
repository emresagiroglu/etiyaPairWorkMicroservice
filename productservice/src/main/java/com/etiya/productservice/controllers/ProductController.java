package com.etiya.productservice.controllers;

import com.etiya.productservice.services.ProductService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping()
    public String hello(){
        return "Hi from Product Service";
    }
}
