package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.client.CustomerServiceClient;
import com.etiya.catalogservice.dtos.customerBasedOffer.*;
import com.etiya.catalogservice.entities.CustomerBasedOffer;
import com.etiya.catalogservice.entities.Offer;
import com.etiya.catalogservice.entities.response.GetCustomerResponse;
import com.etiya.catalogservice.mappers.CustomerBasedOfferMapper;
import com.etiya.catalogservice.repositories.CustomerBasedOfferRepository;
import com.etiya.catalogservice.services.abstracts.CustomerBasedOfferService;
import com.etiya.catalogservice.services.abstracts.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerBasedOfferServiceImpl implements CustomerBasedOfferService {


    private final CustomerBasedOfferRepository customerBasedOfferRepository;
    private final OfferService offerService;
    private final CustomerServiceClient customerServiceClient;

    @Override
    public CreatedCustomerBasedOfferResponseDto add(CreateCustomerBasedOfferRequestDto createCustomerBasedOfferRequest) {
        CustomerBasedOffer customerBasedOffer = CustomerBasedOfferMapper.INSTANCE.customerBasedOfferFromCreateCustomerBasedOfferRequestDto(createCustomerBasedOfferRequest);
        GetCustomerResponse getCustomerResponse = customerServiceClient.getByIdCustomer(createCustomerBasedOfferRequest.getCustomerId());
        CustomerBasedOffer createdCustomerBasedOffer = customerBasedOfferRepository.save(customerBasedOffer);

        CreatedCustomerBasedOfferResponseDto response =
                CustomerBasedOfferMapper.INSTANCE.createCustomerBasedOfferResponseDtoFromCustomerBasedOffer(createdCustomerBasedOffer);


        return response;
    }

    @Override
    public GetCustomerBasedOfferResponseDto getById(UUID id) {
        CustomerBasedOffer customerBasedOffer = customerBasedOfferRepository.findById(id).orElseThrow();

        GetCustomerBasedOfferResponseDto response =
                CustomerBasedOfferMapper.INSTANCE.getCustomerBasedOfferResponseDtoFromCustomerBasedOffer(customerBasedOffer);

        return response;
    }

    @Override
    public List<ListCustomerBasedOfferResponseDto> getAll() {
        List<CustomerBasedOffer> customerBasedOfferList = customerBasedOfferRepository.findAll();
        List<ListCustomerBasedOfferResponseDto> getAllCustomerBasedOfferResponseList = CustomerBasedOfferMapper.INSTANCE.listCustomerBasedOfferResponseDtoFromCustomerBasedOffer(customerBasedOfferList);

        return getAllCustomerBasedOfferResponseList;
    }

    @Override
    public UpdatedCustomerBasedOfferResponseDto update(UUID id, UpdateCustomerBasedOfferRequestDto updateCustomerBasedOfferRequestDto) {
        CustomerBasedOffer customerBasedOffer = customerBasedOfferRepository.findById(id).orElseThrow();

        //customerId başka servisten gelecek.

        //Offer ı güncelleme!
        Offer offer = offerService.findById(updateCustomerBasedOfferRequestDto.getOfferId());
        offer.setId(updateCustomerBasedOfferRequestDto.getOfferId());

        customerBasedOffer.setOffer(offer);

        customerBasedOffer.setCustomerId(updateCustomerBasedOfferRequestDto.getCustomerId());

        customerBasedOfferRepository.save(customerBasedOffer);

        UpdatedCustomerBasedOfferResponseDto response = CustomerBasedOfferMapper.INSTANCE.updateCustomerBasedOfferResponseDtoFromCustomerBasedOffer(customerBasedOffer);

        return response;
    }

    @Override
    public void delete(UUID id) {
        customerBasedOfferRepository.deleteById(id);
    }


}
