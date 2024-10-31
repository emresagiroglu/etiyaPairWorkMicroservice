package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.dtos.product.*;
import com.etiya.catalogservice.entities.Category;
import com.etiya.catalogservice.entities.Product;
import com.etiya.catalogservice.mappers.ProductMapper;
import com.etiya.catalogservice.repositories.ProductRepository;
import com.etiya.catalogservice.rule.ProductBusinessRules;
import com.etiya.catalogservice.services.abstracts.CategoryService;
import com.etiya.catalogservice.services.abstracts.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ProductBusinessRules productBusinessRules;

    @Override
    public CreatedProductResponseDto add(CreateProductRequestDto createProductRequest) {
        // product name check
        productBusinessRules.productWithSameName(createProductRequest.getName());

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

        Category category = categoryService.findById(updateProductRequestDto.getCategoryId());

        product.setName(updateProductRequestDto.getName());
        product.setPrice(updateProductRequestDto.getPrice());
        product.setCategory(category);

        productRepository.save(product);

        UpdatedProductResponseDto response = ProductMapper.INSTANCE.updateProductResponseDtoFromProduct(product);

        return response;
    }

    @Override
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(UUID id) {
        return productRepository.findById(id).orElseThrow();
    }

}
