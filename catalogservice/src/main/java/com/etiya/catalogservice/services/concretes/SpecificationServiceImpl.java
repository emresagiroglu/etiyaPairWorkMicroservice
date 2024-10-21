package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.dtos.specification.*;
import com.etiya.catalogservice.entities.Specification;
import com.etiya.catalogservice.mappers.SpecificationMapper;
import com.etiya.catalogservice.repositories.SpecificationRepository;
import com.etiya.catalogservice.services.abstracts.SpecificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SpecificationServiceImpl implements SpecificationService {


    private final SpecificationRepository specificationRepository;

    @Override
    public CreatedSpecificationResponseDto add(CreateSpecificationRequestDto createSpecificationRequest) {
        Specification specification = SpecificationMapper.INSTANCE.specificationFromCreateSpecificationRequestDto(createSpecificationRequest);
        Specification createdSpecification = specificationRepository.save(specification);

        CreatedSpecificationResponseDto response =
                SpecificationMapper.INSTANCE.createSpecificationResponseDtoFromSpecification(createdSpecification);


        return response;
    }

    @Override
    public GetSpecificationResponseDto getById(UUID id) {
        Specification specification = specificationRepository.findById(id).orElseThrow();

        GetSpecificationResponseDto response =
                SpecificationMapper.INSTANCE.getSpecificationResponseDtoFromSpecification(specification);

        return response;
    }

    @Override
    public List<ListSpecificationResponseDto> getAll() {
        List<Specification> specificationList = specificationRepository.findAll();
        List<ListSpecificationResponseDto> getAllSpecificationResponseList = SpecificationMapper.INSTANCE.listSpecificationResponseDtoFromSpecification(specificationList);

        return getAllSpecificationResponseList;
    }

    @Override
    public UpdatedSpecificationResponseDto update(UUID id, UpdateSpecificationRequestDto updateSpecificationRequestDto) {
        Specification specification = specificationRepository.findById(id).orElseThrow();

        specification.setName(updateSpecificationRequestDto.getName());
        specification.setDataType(updateSpecificationRequestDto.getDataType());

        specificationRepository.save(specification);

        UpdatedSpecificationResponseDto response = SpecificationMapper.INSTANCE.updateSpecificationResponseDtoFromSpecification(specification);

        return response;
    }

    @Override
    public void delete(UUID id) {
        specificationRepository.deleteById(id);
    }

    @Override
    public Specification findById(UUID id) {
        return specificationRepository.findById(id).orElseThrow();
    }


}
