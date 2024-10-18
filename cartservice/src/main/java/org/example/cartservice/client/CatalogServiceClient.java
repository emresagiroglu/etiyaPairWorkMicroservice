package org.example.cartservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "http://localhost:8086/")
public class CatalogServiceClient {
}
