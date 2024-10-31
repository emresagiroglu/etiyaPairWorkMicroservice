package org.example.searchservice.kafka;

import io.github.emresagiroglu.kafka.events.customer.CustomerCreatedEvent;
import lombok.AllArgsConstructor;
import org.example.searchservice.entity.Customer;
import org.example.searchservice.service.FilterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerConsumer {
    private FilterService filterService;
    private final Logger logger = LoggerFactory.getLogger(CustomerConsumer.class);
    @KafkaListener(topics = "customer-created", groupId = "group-id")
    private void consume(CustomerCreatedEvent customerCreatedEvent)
    {
        logger.info(String.valueOf(customerCreatedEvent));
        Customer customer = new Customer();
        customer.setNationalityId(customerCreatedEvent.getNationalityId());
        customer.setId(customerCreatedEvent.getId());
        customer.setFirstName(customerCreatedEvent.getFirstName());
        customer.setMiddleName(customerCreatedEvent.getMiddleName());
        customer.setLastName(customerCreatedEvent.getLastName());
        customer.setPhoneNumber(customerCreatedEvent.getMobilePhone());

        this.filterService.createCustomer(customer);
    }



















//    @KafkaListener(topics = "customer-updated", groupId = "update-customer")
//    private void consume(CustomerUpdatedEvent customerUpdatedEvent)
//    {
//        Customer customer = filterService.getById(customerUpdatedEvent.getId());
//
//        customer.setNationalityId(customerUpdatedEvent.getNationalityId());
//        customer.setId(customerUpdatedEvent.getId());
//        customer.setFirstName(customerUpdatedEvent.getFirstName());
//        customer.setMiddleName(customerUpdatedEvent.getMiddleName());
//        customer.setLastName(customerUpdatedEvent.getLastName());
//
//        this.filterService.updateCustomer(customer);
//    }
//    @KafkaListener(topics = "customer-deleted", groupId = "delete-customer")
//    private void consume(CustomerDeletedEvent customerDeletedEvent)
//    {
//        Customer customer = filterService.getById(customerDeletedEvent.getId());
//        customer.setId(customerDeletedEvent.getId());
//
//        this.filterService.deleteCustomer(customer);
//    }
}
