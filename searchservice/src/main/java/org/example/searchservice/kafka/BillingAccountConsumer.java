package org.example.searchservice.kafka;

import lombok.AllArgsConstructor;
import org.example.searchservice.entity.Customer;
import org.example.searchservice.service.FilterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import io.github.emresagiroglu.kafka.events.billingaccount.BillingAccountCreatedEvent;

@Service
@AllArgsConstructor
public class BillingAccountConsumer {
    private FilterService filterService;
    private final Logger logger = LoggerFactory.getLogger(BillingAccountConsumer.class);

    @KafkaListener(topics = "billingaccount-created",groupId = "group-id")
    private void consume(BillingAccountCreatedEvent billingAccountCreatedEvent)
    {
        logger.info(String.valueOf(billingAccountCreatedEvent));
        Customer customer = this.filterService.getById(billingAccountCreatedEvent.getCustomerId());
        logger.info(customer.toString());
        customer.setAccountNumber(billingAccountCreatedEvent.getAccountNumber());
        this.filterService.updateCustomer(customer);
        logger.info(this.filterService.getById(billingAccountCreatedEvent.getCustomerId()).toString());


    }
}

