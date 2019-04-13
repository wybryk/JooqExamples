package com.jooq.examples.domain.customertrip

import com.jooq.examples.domain.customer.Customer
import com.jooq.examples.domain.trip.Trip

import java.time.LocalDate
import java.time.LocalDateTime

class CustomerTripUtils {
    static def buildCustomerTrip(Trip trip, Customer customer) {
        return CustomerTrip.builder()
                .id(1)
                .customerId(customer.getId())
                .tripId(trip.getId())
                .startDate(LocalDate.of(2019, 4, 13))
                .insertionTime(LocalDateTime.of(2019, 4, 13, 15, 54))
                .build()
    }
}
