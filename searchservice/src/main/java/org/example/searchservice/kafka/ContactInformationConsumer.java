package org.example.searchservice.kafka;

import lombok.AllArgsConstructor;
import org.example.common.kafka.events.contactinformation.ContactInformationUpdatedEvent;
import org.example.searchservice.entity.Customer;
import org.example.searchservice.service.FilterService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactInformationConsumer {
    private FilterService filterService;

    @KafkaListener(topics = "contact-information-updated", groupId = "update-contact-information")
    private void consume(ContactInformationUpdatedEvent contactInformationUpdatedEvent){

        Customer customer = filterService.getById(contactInformationUpdatedEvent.getId());
        customer.setId(contactInformationUpdatedEvent.getId());
        customer.setPhoneNumber(contactInformationUpdatedEvent.getMobilePhone());

        this.filterService.updateCustomer(customer);
    }
}
