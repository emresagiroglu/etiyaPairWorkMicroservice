package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.dtos.productCampaignPackage.*;
import com.etiya.catalogservice.entities.ProductCampaignPackage;
import com.etiya.catalogservice.mappers.ProductCampaignPackageMapper;
import com.etiya.catalogservice.repositories.ProductCampaignPackageRepository;
import com.etiya.catalogservice.services.abstracts.ProductCampaignPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductCampaignPackageServiceImpl implements ProductCampaignPackageService {

    private final ProductCampaignPackageRepository productCampaignPackageRepository;

    @Override
    public CreatedProductCampaignPackageResponseDto add(CreateProductCampaignPackageRequestDto createProductCampaignPackageRequest) {
        ProductCampaignPackage productCampaignPackage = ProductCampaignPackageMapper.INSTANCE.productCampaignPackageFromCreateProductCampaignPackageRequestDto(createProductCampaignPackageRequest);
        ProductCampaignPackage createdProductCampaignPackage = productCampaignPackageRepository.save(productCampaignPackage);

        CreatedProductCampaignPackageResponseDto response =
                ProductCampaignPackageMapper.INSTANCE.createProductCampaignPackageResponseDtoFromProductCampaignPackage(createdProductCampaignPackage);


        return response;
    }

    @Override
    public GetProductCampaignPackageResponseDto getById(UUID id) {
        ProductCampaignPackage productCampaignPackage = productCampaignPackageRepository.findById(id).orElseThrow();

        GetProductCampaignPackageResponseDto response =
                ProductCampaignPackageMapper.INSTANCE.getProductCampaignPackageResponseDtoFromProductCampaignPackage(productCampaignPackage);

        return response;
    }

    @Override
    public List<ListProductCampaignPackageResponseDto> getAll() {
        List<ProductCampaignPackage> productCampaignPackageList = productCampaignPackageRepository.findAll();
        List<ListProductCampaignPackageResponseDto> getAllProductCampaignPackageResponseList = ProductCampaignPackageMapper.INSTANCE.listProductCampaignPackageResponseDtoFromProductCampaignPackage(productCampaignPackageList);

        return getAllProductCampaignPackageResponseList;
    }

    @Override
    public UpdatedProductCampaignPackageResponseDto update(UUID id, UpdateProductCampaignPackageRequestDto updateProductCampaignPackageRequestDto) {
        ProductCampaignPackage productCampaignPackage = productCampaignPackageRepository.findById(id).orElseThrow();

        //bu kısımda product ve campaign güncellenecek servisten findById yapılarak.Sonraya bırakıldı!


        productCampaignPackageRepository.save(productCampaignPackage);

        UpdatedProductCampaignPackageResponseDto response = ProductCampaignPackageMapper.INSTANCE.updateProductCampaignPackageResponseDtoFromProductCampaignPackage(productCampaignPackage);

        return response;
    }

    @Override
    public void delete(UUID id) {
        productCampaignPackageRepository.deleteById(id);
    }


}
