package com.etiya.catalogservice.rule;


import com.etiya.catalogservice.entities.Product;
import com.etiya.catalogservice.repositories.ProductRepository;
import com.etiya.catalogservice.core.exception.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductBusinessRules {
    private final ProductRepository productRepository;

    public void productWithSameName(String productName)
    {
       Optional<Product> product = productRepository.findByName(productName);
        System.out.println(product);
       if(product.isPresent())
       {
           throw new BusinessException("There is a product with same name");
       }
    }
}
