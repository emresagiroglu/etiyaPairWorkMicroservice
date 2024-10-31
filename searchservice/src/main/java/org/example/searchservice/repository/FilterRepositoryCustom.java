package org.example.searchservice.repository;

import org.example.searchservice.entity.Customer;

import java.util.List;

public interface FilterRepositoryCustom {
    List<Customer> searchResult(String nationalityId, String id, String mobilePhone,
                                String accountNumber, String firstName,String middleName, String lastName, String sortField, String sortOrder);
}