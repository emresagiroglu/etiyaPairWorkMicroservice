package org.example.searchservice.repository;

import org.example.searchservice.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public class FilterRepositoryCustomImpl implements FilterRepositoryCustom{
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Customer> searchResult(
            String nationalityId, String id, String mobilePhone, String accountNumber, String firstName, String middleName,String lastName, String sortField, String sortOrder) {

        List<Criteria> criteriaList = new ArrayList<>();

        criteriaList.add(nationalityId != null ? Criteria.where("nationalityId").regex(nationalityId, "i") : null);
        criteriaList.add(id != null && !id.isEmpty() ? Criteria.where("id").regex(id, "i") : null);
        criteriaList.add(mobilePhone != null ? Criteria.where("phoneNumber").regex(mobilePhone, "i") : null);
        criteriaList.add(accountNumber != null ? Criteria.where("accountNumber").regex(accountNumber, "i") : null);
        criteriaList.add(firstName != null && !firstName.isEmpty() ? Criteria.where("firstName").regex(firstName, "i") : null);
        criteriaList.add(middleName != null && !middleName.isEmpty() ? Criteria.where("middleName").regex(middleName, "i") : null);
        criteriaList.add(lastName != null && !lastName.isEmpty() ? Criteria.where("lastName").regex(lastName, "i") : null);

        criteriaList.removeIf(criteria -> criteria == null);
        criteriaList.add(Criteria.where("deletedDate").is(null));

        if (criteriaList.isEmpty()) {
            return mongoTemplate.findAll(Customer.class);
        }

        Query query = new Query();
        query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        query.limit(20);

        // Sıralama için null kontrolü
        if (sortField != null && !sortField.isEmpty()) {
            Sort.Direction direction = "desc".equalsIgnoreCase(sortOrder) ? Sort.Direction.DESC : Sort.Direction.ASC;

            switch (sortField) {
                case "customerId":
                    query.with(Sort.by(direction, "customerId"));
                    break;
                case "firstName":
                    query.with(Sort.by(direction, "firstName"));
                    break;
                case "lastName":
                    query.with(Sort.by(direction, "lastName"));
                    break;
                case "id":
                    query.with(Sort.by(direction, "id"));
                    break;
                default:
                    // Geçersiz sıralama alanı için varsayılan sıralama (örneğin, customerId'ye göre)
                    query.with(Sort.by(Sort.Direction.ASC, "customerId"));
                    break;
            }
        } else {
            // Eğer sortField null ya da boşsa, varsayılan sıralama (örneğin, customerId'ye göre) kullanılabilir
            query.with(Sort.by(Sort.Direction.ASC, "customerId"));
        }

        return mongoTemplate.find(query, Customer.class);
    }



}
