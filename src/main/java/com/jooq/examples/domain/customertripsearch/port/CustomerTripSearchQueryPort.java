package com.jooq.examples.domain.customertripsearch.port;

import com.jooq.examples.domain.customertripsearch.CustomerTripSearch;

import java.util.List;

public interface CustomerTripSearchQueryPort {
    List<CustomerTripSearch> findAll();
}
