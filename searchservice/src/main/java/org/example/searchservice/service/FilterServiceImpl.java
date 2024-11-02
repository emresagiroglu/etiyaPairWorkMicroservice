package org.example.searchservice.service;

import lombok.AllArgsConstructor;
import org.example.searchservice.dto.SearchResponse;
import org.example.searchservice.entity.Customer;
import org.example.searchservice.repository.FilterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FilterServiceImpl implements FilterService{

    private FilterRepository filterRepository;

    @Override
    public void createCustomer(Customer customer) {
        this.filterRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        this.filterRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        this.filterRepository.delete(customer);
    }

    @Override
    public Customer getById(String id) {
        Customer customer = filterRepository.findById(id).get();
        return customer;
    }

    @Override
    public List<SearchResponse> getAll() {

        List<Customer> customerList = filterRepository.findAllByDeletedDateIsNull();

        List<SearchResponse> searchResponses = new ArrayList<>();
        for (Customer customer : customerList) {
            SearchResponse searchResponse = new SearchResponse();
            searchResponse.setId(customer.getId());
            searchResponse.setFirstName(customer.getFirstName());
            searchResponse.setMiddleName(customer.getMiddleName());
            searchResponse.setLastName(customer.getLastName());
            searchResponse.setNationalityId(customer.getNationalityId());
            searchResponse.setAccountNumber(customer.getAccountNumber());
            searchResponse.setMobilePhone(customer.getPhoneNumber());

            searchResponses.add(searchResponse);
        }
        return searchResponses;
    }

    @Override
    public List<SearchResponse> search(
            String nationalityId,
            String id,
            String accountNumber,
            String mobilePhone,
            String firstName,
            String middleName,
            String lastName,
            String sortField,
            String sortOrder) {

        List<Customer> customers =
                this.filterRepository.searchResult(
                        nationalityId, id, mobilePhone, accountNumber, firstName,middleName, lastName,sortField, sortOrder
                );
        List<SearchResponse> searchResponses = new ArrayList<>();

        for (Customer customer : customers) {
            SearchResponse searchResponse = new SearchResponse();
            searchResponse.setId(customer.getId());
            searchResponse.setFirstName(customer.getFirstName());
            searchResponse.setMiddleName(customer.getMiddleName());
            searchResponse.setLastName(customer.getLastName());
            searchResponse.setNationalityId(customer.getNationalityId());
            searchResponse.setAccountNumber(customer.getAccountNumber());
            searchResponse.setMobilePhone(customer.getPhoneNumber());

            searchResponses.add(searchResponse);
        }
        return searchResponses;
    }
}
