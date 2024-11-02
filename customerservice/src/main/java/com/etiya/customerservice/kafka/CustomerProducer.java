package com.etiya.customerservice.kafka;


import io.github.emresagiroglu.kafka.events.customer.CustomerCreatedEvent;
import io.github.emresagiroglu.kafka.events.customer.CustomerDeletedEvent;
import io.github.emresagiroglu.kafka.events.customer.CustomerUpdatedEvent;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CustomerProducer {
    private final KafkaTemplate<String,Object> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(CustomerProducer.class);

    public void sendMessage(CustomerCreatedEvent customerCreatedEvent)
    {
        Message<CustomerCreatedEvent> message = MessageBuilder.withPayload(customerCreatedEvent)
                .setHeader(KafkaHeaders.TOPIC,"customer-created")
                .build();
        logger.info(message.toString());
        kafkaTemplate.send(message);
    }
    public void sendMessage(CustomerUpdatedEvent customerUpdatedEvent){
        Message<CustomerUpdatedEvent> message = MessageBuilder.withPayload(customerUpdatedEvent)
                .setHeader(KafkaHeaders.TOPIC, "customer-updated")
                .build();
        logger.info(message.toString());
        kafkaTemplate.send(message);
    }

    public void sendMessage(CustomerDeletedEvent customerDeletedEvent){

        Message<CustomerDeletedEvent> message = MessageBuilder.withPayload(customerDeletedEvent)
                .setHeader(KafkaHeaders.TOPIC, "customer-deleted")
                .build();
        logger.info(message.toString());
        kafkaTemplate.send(message);
    }
}
