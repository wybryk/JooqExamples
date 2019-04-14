package com.jooq.examples.domain.customertripsearch;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
@Builder
public class CustomerTripSearch {
    private Integer id;
    private CustomerSearch customer;
    private TripSearch trip;
    private LocalDate startDate;
    private LocalDateTime insertionTime;
}
