package org.example.common.kafka.events.billingaccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingAccountCreatedEvent {

    private String customerId;
    private String accountNumber;
}
