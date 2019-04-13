package com.jooq.examples.domain.trip.port;

import com.jooq.examples.domain.trip.Trip;

import java.util.List;

public interface TripQueryPort {
    List<Trip> findAll();
}
