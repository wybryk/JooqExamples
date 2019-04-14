package com.jooq.examples.domain.customertrip

import com.jooq.examples.domain.customer.Customer
import com.jooq.examples.domain.trip.Trip

import java.time.LocalDate
import java.time.LocalDateTime

class CustomerTripUtils {

    static def buildCustomerTrips(List<Trip> trips, List<Customer> customers) {
        return Arrays.asList(
                buildCustomerTrip(1, LocalDate.of(2019, 4, 13),
                        LocalDateTime.of(2019, 4, 13, 15, 54), trips.get(0), customers.get(0)),
                buildCustomerTrip(2, LocalDate.of(2019, 4, 13),
                        LocalDateTime.of(2019, 4, 13, 15, 54), trips.get(0), customers.get(0)),
                buildCustomerTrip(3, LocalDate.of(2019, 4, 13),
                        LocalDateTime.of(2019, 4, 13, 15, 54), trips.get(0), customers.get(1)),
                buildCustomerTrip(4, LocalDate.of(2019, 4, 13),
                        LocalDateTime.of(2019, 4, 13, 15, 54), trips.get(0), customers.get(2)),
                buildCustomerTrip(5, LocalDate.of(2019, 4, 13),
                        LocalDateTime.of(2019, 4, 13, 15, 54), trips.get(0), customers.get(3)),
                buildCustomerTrip(6, LocalDate.of(2019, 4, 13),
                        LocalDateTime.of(2019, 4, 13, 15, 54), trips.get(0), customers.get(3)),
                buildCustomerTrip(7, LocalDate.of(2019, 4, 13),
                        LocalDateTime.of(2019, 4, 13, 15, 54), trips.get(0), customers.get(4)),
                buildCustomerTrip(8, LocalDate.of(2019, 4, 13),
                        LocalDateTime.of(2019, 4, 13, 15, 54), trips.get(0), customers.get(0)),
                buildCustomerTrip(9, LocalDate.of(2019, 4, 13),
                        LocalDateTime.of(2019, 4, 13, 15, 54), trips.get(0), customers.get(2)),
                buildCustomerTrip(10, LocalDate.of(2019, 4, 13),
                        LocalDateTime.of(2019, 4, 13, 15, 54), trips.get(0), customers.get(4))
        )
    }

    static def buildCustomerTrip(Integer id, LocalDate startDate, LocalDateTime insertionTime, Trip trip, Customer customer) {
        return CustomerTrip.builder()
                .id(id)
                .customerId(customer.getId())
                .tripId(trip.getId())
                .startDate(startDate)
                .insertionTime(insertionTime)
                .build()
    }
}
