package org.example.cartservice.client;


import org.example.cartservice.entity.response.GetCustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://localhost:8081/api/customers",name = "customerservice")
public interface CustomerServiceClient {

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    GetCustomerResponse getById(@PathVariable Long id);
}
