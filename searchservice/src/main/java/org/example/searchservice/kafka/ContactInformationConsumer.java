package org.example.searchservice.kafka;

import lombok.AllArgsConstructor;
import org.example.searchservice.entity.Customer;
import org.example.searchservice.service.FilterService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import io.github.emresagiroglu.kafka.events.contactinformation.ContactInformationUpdatedEvent;


@Service
@AllArgsConstructor
public class ContactInformationConsumer {
    private FilterService filterService;

    @KafkaListener(topics = "contact-information-updated", groupId = "group-id")
    private void consume(ContactInformationUpdatedEvent contactInformationUpdatedEvent){

        Customer customer = filterService.getById(contactInformationUpdatedEvent.getId());
        customer.setPhoneNumber(contactInformationUpdatedEvent.getMobilePhone());

        this.filterService.updateCustomer(customer);
    }
}
