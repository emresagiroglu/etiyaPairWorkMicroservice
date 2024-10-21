package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.dtos.category.*;
import com.etiya.catalogservice.dtos.category.*;
import com.etiya.catalogservice.entities.Category;
import com.etiya.catalogservice.mappers.CategoryMapper;
import com.etiya.catalogservice.repositories.CategoryRepository;
import com.etiya.catalogservice.services.abstracts.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CreatedCategoryResponseDto add(CreateCategoryRequestDto createCategoryRequest) {
        Category category = CategoryMapper.INSTANCE.categoryFromCreateCategoryRequestDto(createCategoryRequest);
        Category createdCategory = categoryRepository.save(category);

        CreatedCategoryResponseDto response =
                CategoryMapper.INSTANCE.createCategoryResponseDtoFromCategory(createdCategory);


        return response;
    }

    @Override
    public GetCategoryResponseDto getById(UUID id) {
        Category category = categoryRepository.findById(id).orElseThrow();

        GetCategoryResponseDto response =
                CategoryMapper.INSTANCE.getCategoryResponseDtoFromCategory(category);

        return response;
    }

    @Override
    public List<ListCategoryResponseDto> getAll() {
        List<Category> categoryList = categoryRepository.findAll();
        List<ListCategoryResponseDto> getAllCategoryResponseList = CategoryMapper.INSTANCE.listCategoryResponseDtoFromCategory(categoryList);

        return getAllCategoryResponseList;
    }

    @Override
    public UpdatedCategoryResponseDto update(UUID id, UpdateCategoryRequestDto updateCategoryRequestDto) {
        Category category = categoryRepository.findById(id).orElseThrow();

        category.setName(updateCategoryRequestDto.getName());

        categoryRepository.save(category);

        UpdatedCategoryResponseDto response = CategoryMapper.INSTANCE.updateCategoryResponseDtoFromCategory(category);

        return response;
    }

    @Override
    public void delete(UUID id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(UUID id) {
        return categoryRepository.findById(id).orElseThrow();
    }

}
