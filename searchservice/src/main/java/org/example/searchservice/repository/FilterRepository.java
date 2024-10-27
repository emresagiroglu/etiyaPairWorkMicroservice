package org.example.searchservice.repository;

import org.example.searchservice.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FilterRepository extends MongoRepository<Customer,String>, FilterRepositoryCustom {
    List<Customer> findAllByDeletedDateIsNull();
}
