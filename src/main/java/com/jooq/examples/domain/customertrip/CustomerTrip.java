package com.jooq.examples.domain.customertrip;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
@Builder
public class CustomerTrip {
    private Integer id;
    private Integer customerId;
    private Integer tripId;
    private LocalDate startDate;
    private LocalDateTime insertionTime;
}
