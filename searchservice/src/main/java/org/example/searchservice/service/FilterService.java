package org.example.searchservice.service;

import org.example.searchservice.dto.SearchResponse;
import org.example.searchservice.entity.Customer;

import java.util.List;

public interface FilterService {
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);

    Customer getById(String id);
    List<SearchResponse> getAll();
    List<SearchResponse> search(
            String nationalityId, String id, String accountNumber,
            String mobilePhone, String firstName,String middleName, String lastName,String sortField, String sortOrder
    );
}