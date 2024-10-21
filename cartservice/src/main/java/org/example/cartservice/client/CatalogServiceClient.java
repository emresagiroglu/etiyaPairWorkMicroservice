package org.example.cartservice.client;

import org.example.cartservice.entity.response.GetProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(url = "http://localhost:8090", name = "catalogservice")
public interface CatalogServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "api/catalogs/products/{id}")
    GetProductResponse getById(@PathVariable UUID id);

}
