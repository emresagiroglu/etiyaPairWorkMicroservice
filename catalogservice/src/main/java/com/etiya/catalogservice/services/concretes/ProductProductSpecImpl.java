package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.dtos.productProductSpec.*;
import com.etiya.catalogservice.entities.Product;
import com.etiya.catalogservice.entities.ProductProductSpec;
import com.etiya.catalogservice.entities.ProductSpec;
import com.etiya.catalogservice.mappers.ProductProductSpecMapper;
import com.etiya.catalogservice.repositories.ProductProductSpecRepository;
import com.etiya.catalogservice.services.abstracts.ProductProductSpecService;
import com.etiya.catalogservice.services.abstracts.ProductService;
import com.etiya.catalogservice.services.abstracts.ProductSpecService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductProductSpecImpl implements ProductProductSpecService {


    private final ProductProductSpecRepository productProductSpecRepository;
    private final ProductService productService;
    private final ProductSpecService productSpecService;

    @Override
    public CreatedProductProductSpecResponseDto add(CreateProductProductSpecRequestDto createProductProductSpecRequest) {
        ProductProductSpec productProductSpec = ProductProductSpecMapper.INSTANCE.productProductSpecFromCreateProductProductSpecRequestDto(createProductProductSpecRequest);
        ProductProductSpec createdProductProductSpec = productProductSpecRepository.save(productProductSpec);

        CreatedProductProductSpecResponseDto response =
                ProductProductSpecMapper.INSTANCE.createProductProductSpecResponseDtoFromProductProductSpec(createdProductProductSpec);


        return response;
    }

    @Override
    public GetProductProductSpecResponseDto getById(UUID id) {
        ProductProductSpec productProductSpec = productProductSpecRepository.findById(id).orElseThrow();

        GetProductProductSpecResponseDto response =
                ProductProductSpecMapper.INSTANCE.getProductProductSpecResponseDtoFromProductProductSpec(productProductSpec);

        return response;
    }

    @Override
    public List<ListProductProductSpecResponseDto> getAll() {
        List<ProductProductSpec> productProductSpecList = productProductSpecRepository.findAll();
        List<ListProductProductSpecResponseDto> getAllProductProductSpecResponseList = ProductProductSpecMapper.INSTANCE.listProductProductSpecResponseDtoFromProductProductSpec(productProductSpecList);

        return getAllProductProductSpecResponseList;
    }

    @Override
    public UpdatedProductProductSpecResponseDto update(UUID id, UpdateProductProductSpecRequestDto updateProductProductSpecRequestDto) {
        ProductProductSpec productProductSpec = productProductSpecRepository.findById(id).orElseThrow();

        Product product = productService.findById(updateProductProductSpecRequestDto.getProductId());
        ProductSpec productSpec = productSpecService.findById(updateProductProductSpecRequestDto.getProductSpecId());

        productProductSpec.setProduct(product);
        productProductSpec.setProductSpec(productSpec);

        productProductSpecRepository.save(productProductSpec);

        UpdatedProductProductSpecResponseDto response = ProductProductSpecMapper.INSTANCE.updateProductProductSpecResponseDtoFromProductProductSpec(productProductSpec);

        return response;
    }

    @Override
    public void delete(UUID id) {
        productProductSpecRepository.deleteById(id);
    }


}
