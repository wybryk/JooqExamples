package com.jooq.examples.domain.customertrip.port;

import com.jooq.examples.domain.customertrip.CustomerTrip;

public interface CustomerTripCommandPort {
    void insert(CustomerTrip customerTrip);
    void deleteAll();
}
