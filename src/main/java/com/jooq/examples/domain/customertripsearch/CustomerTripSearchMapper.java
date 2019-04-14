package com.jooq.examples.domain.customertripsearch;

import org.jooq.Record;

import static com.jooq.examples.testdb.public_.tables.Customer.CUSTOMER;
import static com.jooq.examples.testdb.public_.tables.CustomerTrip.CUSTOMER_TRIP;
import static com.jooq.examples.testdb.public_.tables.Destination.DESTINATION;
import static com.jooq.examples.testdb.public_.tables.Trip.TRIP;

class CustomerTripSearchMapper {
    CustomerTripSearch map(Record record) {
        return CustomerTripSearch.builder()
                .id(record.get(CUSTOMER_TRIP.ID))
                .customer(buildCustomer(record))
                .trip(buildTrip(record))
                .startDate(record.get(CUSTOMER_TRIP.START_DATE).toLocalDate())
                .insertionTime(record.get(CUSTOMER_TRIP.INSERTION_TIME).toLocalDateTime())
                .build();
    }

    private CustomerSearch buildCustomer(Record record) {
        return CustomerSearch.builder()
                .id(record.get(CUSTOMER.ID))
                .firstName(record.get(CUSTOMER.FIRST_NAME))
                .lastName(record.get(CUSTOMER.LAST_NAME))
                .build();
    }

    private TripSearch buildTrip(Record record) {
        return TripSearch.builder()
                .id(record.get(TRIP.ID))
                .title(record.get(TRIP.TITLE))
//                .transportType(record.get(TRIP.TRANSPORT_TYPE))
                .duration(record.get(TRIP.DURATION))
                .price(record.get(TRIP.PRICE))
                .destination(buildDestination(record))
                .build();
    }

    private DestinationSearch buildDestination(Record record) {
        return DestinationSearch.builder()
                .id(record.get(DESTINATION.ID))
                .country(record.get(DESTINATION.COUNTRY))
                .build();
    }
}
