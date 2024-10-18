package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.dtos.productProductSpec.*;
import com.etiya.catalogservice.entities.ProductProductSpec;
import com.etiya.catalogservice.mappers.ProductProductSpecMapper;
import com.etiya.catalogservice.repositories.ProductProductSpecRepository;
import com.etiya.catalogservice.services.abstracts.ProductProductSpecService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductProductSpecImpl implements ProductProductSpecService {


    private final ProductProductSpecRepository productProductSpecRepository;

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

        //bağlı olan sınıfların update işlemi servisten çekilerek yapılacak. Sonra Bak!!

        productProductSpecRepository.save(productProductSpec);

        UpdatedProductProductSpecResponseDto response = ProductProductSpecMapper.INSTANCE.updateProductProductSpecResponseDtoFromProductProductSpec(productProductSpec);

        return response;
    }

    @Override
    public void delete(UUID id) {
        productProductSpecRepository.deleteById(id);
    }


}
