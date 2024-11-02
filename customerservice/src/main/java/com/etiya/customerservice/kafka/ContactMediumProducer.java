package com.etiya.customerservice.kafka;


import io.github.emresagiroglu.kafka.events.contactinformation.ContactInformationUpdatedEvent;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ContactMediumProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;



    public void sendMessage(ContactInformationUpdatedEvent contactInformationUpdatedEvent){

        Message<ContactInformationUpdatedEvent> message = MessageBuilder.withPayload(contactInformationUpdatedEvent)
                .setHeader(KafkaHeaders.TOPIC, "contact-medium-updated")
                .build();

        kafkaTemplate.send(message);
    }
}
