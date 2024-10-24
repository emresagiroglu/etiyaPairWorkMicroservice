package com.etiya.catalogservice.client;

import com.etiya.catalogservice.entities.response.GetAddressResponse;
import com.etiya.catalogservice.entities.response.GetCustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://localhost:8081/api/customers",name = "customerservice")
public interface CustomerServiceClient {
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    GetCustomerResponse getByIdCustomer(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.GET,value = "/addresses/{id}")
    GetAddressResponse getByIdAddress(@PathVariable Long id);
}
