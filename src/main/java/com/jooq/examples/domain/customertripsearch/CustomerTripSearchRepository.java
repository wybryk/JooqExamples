package com.jooq.examples.domain.customertripsearch;

import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.jooq.examples.testdb.public_.tables.Customer.CUSTOMER;
import static com.jooq.examples.testdb.public_.tables.CustomerTrip.CUSTOMER_TRIP;
import static com.jooq.examples.testdb.public_.tables.Destination.DESTINATION;
import static com.jooq.examples.testdb.public_.tables.Trip.TRIP;

@Repository
@AllArgsConstructor
class CustomerTripSearchRepository {
    private final DSLContext dslContext;

    List<CustomerTripSearch> findAll() {
        return dslContext.select()
                .from(CUSTOMER_TRIP
                        .join(CUSTOMER).on(CUSTOMER_TRIP.CUSTOMER_ID.eq(CUSTOMER.ID))
                        .join(TRIP).on(CUSTOMER_TRIP.TRIP_ID.eq(TRIP.ID))
                        .join(DESTINATION).on(TRIP.DESTINATION_ID.eq(DESTINATION.ID))
                )
                .fetch()
                .stream()
                .map(new CustomerTripSearchMapper()::map)
                .collect(Collectors.toList());
    }
}
