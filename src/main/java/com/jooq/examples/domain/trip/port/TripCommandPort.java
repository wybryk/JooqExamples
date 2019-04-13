package com.jooq.examples.domain.trip.port;

import com.jooq.examples.domain.trip.Trip;

public interface TripCommandPort {
    void insert(Trip trip);
    void deleteAll();
}
