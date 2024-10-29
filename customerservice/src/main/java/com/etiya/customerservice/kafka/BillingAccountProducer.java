package com.etiya.customerservice.kafka;

import io.github.emresagiroglu.kafka.events.billingaccount.BillingAccountCreatedEvent;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
@Service
@AllArgsConstructor
public class BillingAccountProducer {
    private final KafkaTemplate<String,Object> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(BillingAccountProducer.class);


    public void sendMessage(BillingAccountCreatedEvent billingAccountCreatedEvent)
    {
        Message<BillingAccountCreatedEvent> message = MessageBuilder.withPayload(billingAccountCreatedEvent)
                .setHeader(KafkaHeaders.TOPIC, "billingaccount-created")
                .build();
        logger.info(message.toString());
        kafkaTemplate.send(message);
    }

}
