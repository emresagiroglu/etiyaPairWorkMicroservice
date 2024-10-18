package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.dtos.productSpec.*;
import com.etiya.catalogservice.entities.ProductSpec;
import com.etiya.catalogservice.mappers.ProductSpecMapper;
import com.etiya.catalogservice.repositories.ProductSpecRepository;
import com.etiya.catalogservice.services.abstracts.ProductSpecService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductSpecServiceImpl implements ProductSpecService {


    private final ProductSpecRepository productSpecRepository;

    @Override
    public CreatedProductSpecResponseDto add(CreateProductSpecRequestDto createProductSpecRequest) {
        ProductSpec productSpec = ProductSpecMapper.INSTANCE.productSpecFromCreateProductSpecRequestDto(createProductSpecRequest);
        ProductSpec createdProductSpec = productSpecRepository.save(productSpec);

        CreatedProductSpecResponseDto response =
                ProductSpecMapper.INSTANCE.createProductSpecResponseDtoFromProductSpec(createdProductSpec);


        return response;
    }

    @Override
    public GetProductSpecResponseDto getById(UUID id) {
        ProductSpec productSpec = productSpecRepository.findById(id).orElseThrow();

        GetProductSpecResponseDto response =
                ProductSpecMapper.INSTANCE.getProductSpecResponseDtoFromProductSpec(productSpec);

        return response;
    }

    @Override
    public List<ListProductSpecResponseDto> getAll() {
        List<ProductSpec> productSpecList = productSpecRepository.findAll();
        List<ListProductSpecResponseDto> getAllProductSpecResponseList = ProductSpecMapper.INSTANCE.listProductSpecResponseDtoFromProductSpec(productSpecList);

        return getAllProductSpecResponseList;
    }


    @Override
    public UpdatedProductSpecResponseDto update(UUID id, UpdateProductSpecRequestDto updateProductSpecRequestDto) {
        ProductSpec productSpec = productSpecRepository.findById(id).orElseThrow();

        productSpec.setValue(updateProductSpecRequestDto.getValue());

        //spec in update işlemi sonra yapılacak bak!

        productSpecRepository.save(productSpec);

        UpdatedProductSpecResponseDto response = ProductSpecMapper.INSTANCE.updateProductSpecResponseDtoFromProductSpec(productSpec);

        return response;
    }

    @Override
    public void delete(UUID id) {
        productSpecRepository.deleteById(id);
    }

}
