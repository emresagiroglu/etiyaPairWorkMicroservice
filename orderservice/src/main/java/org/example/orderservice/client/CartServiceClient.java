package org.example.orderservice.client;

import org.example.orderservice.entity.response.CartResponse;
import org.example.orderservice.entity.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;
@FeignClient(url = "http://localhost:8090", name = "cartservice")
public interface CartServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "api/carts/{customerId}")
    CartResponse getCartByCustomerId(@PathVariable Long customerId);


}
