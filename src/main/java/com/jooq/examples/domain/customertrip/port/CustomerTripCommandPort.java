package com.jooq.examples.domain.customertrip.port;

import com.jooq.examples.domain.customertrip.CustomerTrip;

import java.util.List;

public interface CustomerTripCommandPort {
    void insert(CustomerTrip customerTrip);
    void insertAll(List<CustomerTrip> customerTrips);
    void deleteAll();
}
