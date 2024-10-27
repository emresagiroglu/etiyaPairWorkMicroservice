package org.example.common.kafka.events.contactinformation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactInformationUpdatedEvent {
    private String id;
    private String mobilePhone;
}
