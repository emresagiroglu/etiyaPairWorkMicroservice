package com.etiya.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CatalogserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogserviceApplication.class, args);
	}

}
