package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.category.*;
import com.etiya.catalogservice.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CreatedCategoryResponseDto createCategoryResponseDtoFromCategory(Category category);
    GetCategoryResponseDto getCategoryResponseDtoFromCategory(Category category);
    List<ListCategoryResponseDto> listCategoryResponseDtoFromCategory(List<Category> dto);
    Category categoryFromCreateCategoryRequestDto(CreateCategoryRequestDto dto);
    Category categoryFromUpdateCategoryRequestDto(UpdateCategoryRequestDto dto);
    UpdatedCategoryResponseDto updateCategoryResponseDtoFromCategory(Category dto);
}
