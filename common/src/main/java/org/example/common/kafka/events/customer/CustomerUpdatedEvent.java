package org.example.common.kafka.events.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdatedEvent {

        private String nationalityId;
        private String id;
        private String accountNumber;
        private String firstName;
        private String middleName;
        private String lastName;
        private String orderNumber;
}
