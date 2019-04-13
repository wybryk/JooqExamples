package com.jooq.examples.domain.customertrip.port;

import com.jooq.examples.domain.customertrip.CustomerTrip;

import java.util.List;

public interface CustomerTripQueryPort {
    List<CustomerTrip> findAll();
}
