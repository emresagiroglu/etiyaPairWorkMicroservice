package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.dtos.product.*;
import com.etiya.catalogservice.entities.Product;
import com.etiya.catalogservice.mappers.ProductMapper;
import com.etiya.catalogservice.repositories.ProductRepository;
import com.etiya.catalogservice.services.abstracts.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Override
    public CreatedProductResponseDto add(CreateProductRequestDto createProductRequest) {
        Product product = ProductMapper.INSTANCE.productFromCreateProductRequestDto(createProductRequest);
        Product createdProduct = productRepository.save(product);

        CreatedProductResponseDto response =
                ProductMapper.INSTANCE.createProductResponseDtoFromProduct(createdProduct);


        return response;
    }

    @Override
    public GetProductResponseDto getById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow();

        GetProductResponseDto response =
                ProductMapper.INSTANCE.getProductResponseDtoFromProduct(product);

        return response;
    }

    @Override
    public List<ListProductResponseDto> getAll() {
        List<Product> productList = productRepository.findAll();
        List<ListProductResponseDto> getAllProductResponseList = ProductMapper.INSTANCE.listProductResponseDtoFromProduct(productList);

        return getAllProductResponseList;
    }

    @Override
    public UpdatedProductResponseDto update(UUID id, UpdateProductRequestDto updateProductRequestDto) {
        Product product = productRepository.findById(id).orElseThrow();

        product.setName(updateProductRequestDto.getName());

        //category update leme sonraya bırakıldı!

        productRepository.save(product);

        UpdatedProductResponseDto response = ProductMapper.INSTANCE.updateProductResponseDtoFromProduct(product);

        return response;
    }

    @Override
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }

}