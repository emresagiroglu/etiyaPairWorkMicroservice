package org.example.orderservice.client;

import org.example.orderservice.entity.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;


@FeignClient(url = "http://localhost:8090", name = "catalogservice")
public interface CatalogServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "api/catalogs/products/{id}")
    ProductResponse getById(@PathVariable UUID id);
}
