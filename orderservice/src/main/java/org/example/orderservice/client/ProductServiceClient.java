package org.example.orderservice.client;

import org.example.orderservice.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@FeignClient(name = "productservice")
public interface ProductServiceClient {
    @PostMapping("/api/products/search")
    List<Product> findAllByIds(List<Long> ids);
}
